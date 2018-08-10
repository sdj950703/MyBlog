package com.myblog.dao;

import com.myblog.model.Visitor;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer vId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer vId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

	Visitor vsitorSelective(Visitor visitor);
}