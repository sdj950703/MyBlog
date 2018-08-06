package com.myblog.service;

import org.springframework.web.multipart.MultipartFile;

import com.myblog.model.Admin;
import com.myblog.model.ImgResult;

public interface IAdminService {
	/**
	 * 验证登录
	 * @param admin Admin对象，用于存储数据
	 * @return admin对象，用于返回查询信息
	 */
	Admin login(Admin admin);
    
	/**
	 * 上传单个文件到服务器
	 * @param savePath 文件的存储路径
	 * @param file 文件对象
	 */
	void updateImg(String savePath, MultipartFile file);
    /**
     * 修改Admin信息
     * @param admin admin对象，存储数据
     * @return 
     */
	boolean updateAdmin(Admin admin);


}
