package com.myblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myblog.model.Blog;
import com.myblog.model.ImgResult;
import com.myblog.service.IBlogService;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	@Autowired
	IBlogService blogService;

	/**
	 * 根据id删除博文
	 * 
	 * @param bid
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/{bid}", params = ("method=deleteBlog"))
	public String deleteBlog(@PathVariable("bid") Integer bid, ModelMap map) {
		int count = blogService.deleteBlogByPK(bid);
		String msg = "删除失败";
		if (count > 0) {
			msg = "删除成功";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	/**
	 * 根据id查询博文，并且返回到修改博文页面
	 * 
	 * @param bid
	 *            博文id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/{bid}")
	public String toEditBlog(@PathVariable("bid") Integer bid, ModelMap map) {
		Blog blog = blogService.selectBlogByPK(bid);
		map.addAttribute("blog", blog);
		return "admin/editBlog";

	}

	@RequestMapping(value = "/editBlog", method = RequestMethod.POST)
	public String editBlog(Blog blog, ModelMap map) {
		int count = blogService.editBlog(blog);
		String msg = "修改失败";
		if (count > 0) {
			msg = "修改成功";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	/**
	 * 查询所有blog信息，但不包括content字段
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping
	public String selectAll(ModelMap map, String msg) {
		List<Blog> bologList = blogService.selectAll();
		map.addAttribute("blogList", bologList);
		map.addAttribute("msg", msg);
		return "admin/bloginfo";
	}

	/**
	 * 添加博文信息
	 * 
	 * @param blog
	 * @param map
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String addBlogInfo(Blog blog, ModelMap map) {
		int count = blogService.insertBlog(blog);
		String msg = "添加失败";
		if (count > 0) {
			msg = "添加成功";
		}
		map.addAttribute("msg", msg);
		return "redirect:/blog";
	}

	/**
	 * 跳转到添加博文信息页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAddBlog")
	public String toAddBlog() {
		return "admin/addBlog";

	}

	// 将return的内容直接加入响应体
	@ResponseBody
	@RequestMapping(value = "imgUpload")
	public ImgResult upload(@RequestParam(value = "img") MultipartFile file,
			HttpServletRequest req) {
		String savePath = req.getServletContext().getRealPath("upload");
		ImgResult imgResult = blogService.uploadImgs(savePath, file);
		return imgResult;
	}

}
