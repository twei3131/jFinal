package com.twei3131.service;

import java.util.List;

import com.twei3131.model.Blog;

public class BlogService {
	private static final Blog dao = new Blog();
	
	public List<Blog> search(String keywords){
		return dao.find("select * from blog where keywords = ?",keywords);
	}
}
