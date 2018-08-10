package com.myblog.service.Impl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myblog.dao.BlogMapper;
import com.myblog.model.Blog;
import com.myblog.model.ImgResult;
import com.myblog.service.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService {

	@Autowired
	private BlogMapper blogMapper;

	@Override
	public ImgResult uploadImgs(String savePath, MultipartFile file) {
		// 文件路径
		String filePath = savePath + File.separator
				+ file.getOriginalFilename();
		File saveFile = new File(filePath);
		// 判断文件的父路径是否存在，若不存在，则创建
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		try {
			// 写入文件，相当于输出流的write方法
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		ImgResult imgResult = new ImgResult();
		imgResult.setErrno("0");
		String[] urlDate = new String[2];
		urlDate[0] = "/MyBlog/upload/" + file.getOriginalFilename();
		imgResult.setData(urlDate);
		return imgResult;
	}

	/**
	 * 查询所有博文信息不包括content字段
	 */
	@Override
	public List<Blog> selectAll() {
		return blogMapper.selectAll();
	}

	/**
	 * 添加博文信息
	 */
	@Override
	public int insertBlog(Blog blog) {
		Date createTime = new Date(System.currentTimeMillis());
		blog.setCreatetime(createTime);
		blog.setReadcount(0);
		return blogMapper.insertSelective(blog);
	}

	/**
	 * 根据id查询博文
	 */
	@Override
	public Blog selectBlogByPK(Integer bid) {
		return blogMapper.selectByPrimaryKey(bid);
	}

	/**
	 * 根据id删除博文
	 */
	@Override
	public int deleteBlogByPK(Integer bid) {
		return blogMapper.deleteByPrimaryKey(bid);
	}

	/**
	 * 修改博文
	 */
	@Override
	public int editBlog(Blog blog) {
		return blogMapper.updateByPrimaryKeySelective(blog);
	}

	/**
	 * 根据创建时间排序查询博文
	 */
	@Override
	public List<Blog> selectBlogOrderByDate() {
		return blogMapper.selectBlogOrderByDate();
	}

	/**
	 * 根据阅读量排序查询博文
	 */
	@Override
	public List<Blog> selectBlogOrderByReadCount() {
		return blogMapper.selectBlogOrderByReadCount();
	}

	/**
	 * 查询所有的博文并且根据时间排序显示到博文列表页面
	 */
	@Override
	public List<Blog> selectAllBlogOrderByDate() {
		return blogMapper.selectAllBlogOrderByDate();
	}

	@Override
	public int updateReadCountByPK(Integer bid) {
		return blogMapper.updateReadCountByPK(bid);
	}

}
