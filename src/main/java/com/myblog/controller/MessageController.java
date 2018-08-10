package com.myblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myblog.model.Message;
import com.myblog.service.IMessageService;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping(value = "sendMessage")
	public String toSendMessage() {
		return "sendmessage";
	}

	@RequestMapping(value = "sendMessage", method = RequestMethod.POST)
	public String sendMessage(Message message, ModelMap map) {
		int count = messageService.insertMessage(message);
		String msg = "留言失败";
		if (count > 0) {
			msg = "留言成功";
		}
		map.addAttribute("msg", msg);
		return "redirect:/main";
	}
}
