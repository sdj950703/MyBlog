package com.myblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myblog.model.Admin;
import com.myblog.service.IAdminService;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping
	public String checkLogin(){
		return "admin/adminLogin";
	}
	
	@RequestMapping(value="login")
	public String adminLogin(Admin admin,String remember,HttpServletRequest req,HttpServletResponse resp){
		Admin loginAdmin = adminService.login(admin);
		if(loginAdmin!=null){
			if(remember!=null){
				//用cookie记录登录信息
				Cookie cookie_email=new Cookie("email", admin.getEmail());
				Cookie cookie_pass=new Cookie("pass", admin.getPass());
				//设置cookie生存时间，单位是秒
				cookie_email.setMaxAge(20);
				cookie_pass.setMaxAge(20);
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

}
