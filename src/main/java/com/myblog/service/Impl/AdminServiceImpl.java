package com.myblog.service.Impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myblog.dao.AdminMapper;
import com.myblog.model.Admin;
import com.myblog.model.ImgResult;
import com.myblog.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminMapper adminMapper;
    
	/**
	 * 管理员登录
	 * @param admin,映射类对象，用于存储数据
	 * @return 根据参数查询数据库返回的映射类对象，用于传递数据
	 */
	@Override
	public Admin login(Admin admin) {
		return adminMapper.login(admin);
	}
    
	/**
	 * 上传单个文件
	 * @param savePath 文件存储路径
	 */
	@Override
	public void updateImg(String savePath, MultipartFile file) {
		//文件路径
		String filePath=savePath+File.separator+file.getOriginalFilename();
		File saveFile=new File(filePath);
		//判断文件的父路径是否存在，若不存在，则创建
		if(!saveFile.getParentFile().exists()){
			saveFile.getParentFile().mkdirs();
		}
		try {
			//写入文件，相当于输出流的write方法
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
    /**
     * 修改Admin信息
     * @return 
     */
	@Override
	public boolean updateAdmin(Admin admin) {
		return adminMapper.updateByPrimaryKey(admin)>0;
		
	}

	

}
