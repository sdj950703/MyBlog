package com.myblog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.myblog.model.Blog;
import com.myblog.model.ImgResult;

public interface IBlogService {

	ImgResult uploadImgs(String savePath, MultipartFile file);

	List<Blog> selectAll();

	int insertBlog(Blog blog);

	Blog selectBlogByPK(Integer bid);

	int deleteBlogByPK(Integer bid);

	int editBlog(Blog blog);

	List<Blog> selectBlogOrderByDate();

	List<Blog> selectBlogOrderByReadCount();

	List<Blog> selectAllBlogOrderByDate();

	int updateReadCountByPK(Integer bid);

}
