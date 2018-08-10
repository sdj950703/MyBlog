package com.myblog.service;

import org.springframework.web.multipart.MultipartFile;

import com.myblog.model.Admin;

public interface IAdminService {
	
	Admin login(Admin admin);
    
	void updateImg(String savePath, MultipartFile file);
    
	boolean updateAdmin(Admin admin);

	Admin selectAdminByPrimaryKey(int i);


}
