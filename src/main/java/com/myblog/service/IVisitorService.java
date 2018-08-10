package com.myblog.service;

import com.myblog.model.Visitor;

public interface IVisitorService {

	int insertVisitor(Visitor visitor);
	
	Visitor selectVisitor(Visitor visitor);

}
