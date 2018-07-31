package com.myblog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dao.AdminMapper;
import com.myblog.model.Admin;
import com.myblog.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin login(Admin admin) {
		return adminMapper.login(admin);
	}

}
