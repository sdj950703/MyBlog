package com.myblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myblog.model.Admin;
import com.myblog.service.IAdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	/**
	 * 检查登陆状态并读取相关cookie
	 * 
	 * @param req request对象
	 * 
	 * @return 若cookie验证有效，自动登陆，否则跳转到adminLogin界面
	 */
	@RequestMapping
	public String checkLogin(HttpServletRequest req,String msg,ModelMap model){
		System.out.println(msg);
		//获取cookie
		Cookie[] cookies=req.getCookies();
		if(cookies != null){
			String email=null;
			String pass=null;
			for (Cookie cookie : cookies) {
				if("email".equals(cookie.getName())){
					email=cookie.getValue();
				}else if("pass".equals(cookie.getName())){
					pass=cookie.getValue();
				}
			}
			//重新验证记住的邮箱和密码
			Admin admin=new Admin();
			admin.setEmail(email);
			admin.setPass(pass);
			Admin loginAdmin = adminService.login(admin);
			if(loginAdmin != null){
				model.addAttribute("msg", msg);
				req.getSession().setAttribute("admin", loginAdmin);
				return "admin/adminInfo";
			}
		}
		req.getSession().removeAttribute("admin");
		return "admin/adminLogin";
	}
	/**
	 * 管理员登录，并添加可以保存登录信息的cookie
	 * @param admin 实体类对象，存储页面表单传递的参数
	 * @param remember 是否添加cookie的标志符
	 * @param req request对象
	 * @param resp response对象
	 * @return 登陆成功-adminInfo.jsp 登陆失败-adminLogin.jsp
	 */
	@RequestMapping(value="/login")
	public String adminLogin(Admin admin,String remember,HttpServletRequest req,HttpServletResponse resp){
		Admin loginAdmin = adminService.login(admin);
		if(loginAdmin!=null){
			if(remember!=null){
				//用cookie记录登录信息
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				//设置cookie生存时间，单位是秒
				cookie_email.setMaxAge(60);
				cookie_pass.setMaxAge(60);
				//把cookie添加到响应头文件中
				resp.addCookie(cookie_email);
				resp.addCookie(cookie_pass);
			}
			//用session记录登录状态
			req.getSession().setAttribute("admin", loginAdmin);
			return "admin/adminInfo";
		}
		req.setAttribute("msg", "用户名密码错误");
		return "admin/adminLogin";
	}
	/**
	 * 注销登录，删除存储的登录信息
	 * @param req request对象
	 * @param resp response对象
	 * @return 跳转到登陆界面
	 */
	@RequestMapping("/logout")
	public String adminLogOut(HttpServletRequest req,HttpServletResponse resp){
		//删除session存储的登录信息
		req.getSession().removeAttribute("admin");
		//获取cookie内容
		Cookie[] cookies=req.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if("email".equals(cookie.getName()) || "pass".equals(cookie.getName())){
					//设置cookie最大生存时间为0，cookie对象立即失效
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
		}
		return "admin/adminLogin";
		
	}
	/**
	 * 修改管理员信息
	 * @param admin 映射类对象，用于存储表单数据
	 * @param file 多媒体文件对象，用于存储文件上传的数据
	 * @param req request对象
	 * @return
	 */
	@RequestMapping(value="/updateAdmin",method=RequestMethod.POST)
	public String updateAdmin(Admin admin,
			@RequestParam(value="imgFile",required=false) MultipartFile file,
			HttpServletRequest req,ModelMap model){
		if(!file.isEmpty()){
			//文件存储路径
			String savePath=req.getServletContext().getRealPath("upload");
			adminService.updateImg(savePath,file);
			admin.setImg("/upload/"+file.getOriginalFilename());
		}
		String msg="修改失败!";
		boolean flag = adminService.updateAdmin(admin);
		if(flag){
			msg="修改成功!";
		}
		model.addAttribute("msg", msg);
		return "redirect:/admin";
		
	}

}
