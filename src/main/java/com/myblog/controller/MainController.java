package com.myblog.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myblog.model.Admin;
import com.myblog.model.Blog;
import com.myblog.model.Visitor;
import com.myblog.service.IAdminService;
import com.myblog.service.IBlogService;
import com.myblog.service.IVisitorService;

@Controller
@RequestMapping(value = "/main")
public class MainController {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private IBlogService blogService;

	@Autowired
	private IVisitorService visitorService;

	
	/**
	 * 查询博主信息 分别按时间顺序和阅读量查询博文
	 * 
	 * @param map
	 * @param session
	 * @return 返回博客首页显示信息
	 */
	@RequestMapping
	public String toMainPage(ModelMap map, HttpSession session, String msg) {
		// 查询博主信息
		Admin admin = adminService.selectAdminByPrimaryKey(1);
		// 根据时间查询博文
		List<Blog> blogListByDate = blogService.selectBlogOrderByDate();
		// 根据阅读量查询博文列表
		List<Blog> blogListByReadCount = blogService
				.selectBlogOrderByReadCount();
		session.setAttribute("admin", admin);
		map.addAttribute("blogListByDate", blogListByDate);
		session.setAttribute("blogListByReadCount", blogListByReadCount);
		map.addAttribute("msg", msg);
		return "main";

	}
	
	@RequestMapping(value = "zan")
	public String zan() {
		return "zanzhu";
	}

	/**
	 * 查询所有博文并且根据创建时间进行排序，展示到博文列表页面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/toBlogList")
	public String blogList(ModelMap map, HttpServletRequest req) {
		// 根据时间查询所有博文
		List<Blog> allBlog = blogService.selectBlogOrderByReadCount();
		String option = req.getParameter("option");
		if ("时间".equals(option)) {
			allBlog = blogService.selectAllBlogOrderByDate();
		}
		map.addAttribute("allBlog", allBlog);
		return "bloglist";

	}

	/**
	 * 根据id查询博文，跳转到详细页面显示详细信息，点击之后阅读量加1 获取访问者的ip，访问时间，访问的博文id，记录到数据库中
	 * 判断访问者是否是一天内重复阅读某个博文，条件：同一天，同一个博文，同一个ip 如果是，该博文访问量不再增加 如果不是，访问量加1
	 * 
	 * @param bid
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/blogDetail/{bid}")
	public String toBlogDetail(@PathVariable("bid") Integer bid, ModelMap map,
			HttpServletRequest req) {

		Visitor visitor = new Visitor();
		visitor.setIpadress(req.getRemoteAddr());
		visitor.setbId(bid);
		visitor.setVisitttime(new Date(System.currentTimeMillis()));
		int count = visitorService.insertVisitor(visitor);
		if (count > 0) {
			blogService.updateReadCountByPK(bid);
		}

		Blog blog = blogService.selectBlogByPK(bid);
		List<Blog> blogListByReadCount = blogService
				.selectBlogOrderByReadCount();
		map.addAttribute("blog", blog);
		map.addAttribute("blogListByReadCount", blogListByReadCount);
		return "blogDetail";
	}


}
