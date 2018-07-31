package com.myblog.dao;

import org.springframework.stereotype.Repository;

import com.myblog.model.Admin;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer amId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer amId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin login(Admin admin);
}