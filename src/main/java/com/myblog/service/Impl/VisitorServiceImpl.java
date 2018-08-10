package com.myblog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dao.VisitorMapper;
import com.myblog.model.Visitor;
import com.myblog.service.IVisitorService;

@Service
public class VisitorServiceImpl implements IVisitorService {

	@Autowired
	private VisitorMapper visitorMapper;

	/**
	 * 添加访问者信息到数据库
	 */
	@Override
	public int insertVisitor(Visitor visitor) {
		Visitor v = this.selectVisitor(visitor);
		if (v == null) {
			return visitorMapper.insert(visitor);
		}
		return 0;
	}

	/**
	 * 查询当前访问者是否存在 条件：在同一天访问过同一个博文，用同一个ip
	 */
	@Override
	public Visitor selectVisitor(Visitor visitor) {
		return visitorMapper.vsitorSelective(visitor);
	}

}
