package com.myblog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dao.MessageMapper;
import com.myblog.model.Message;
import com.myblog.service.IMessageService;

@Service
public class MessageImpl implements IMessageService {

	@Autowired
	private MessageMapper messageMapper;

	/**
	 * 添加留言信息
	 */
	@Override
	public int insertMessage(Message message) {
		return messageMapper.insert(message);
	}

}
