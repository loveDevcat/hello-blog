package com.example.helloblog.service;

import com.example.helloblog.domain.Blog;

import java.util.List;

public interface BlogListService {
    List<Blog> findAllBlog();

    Blog findBlogById(Integer id);

    Blog addBlog(Blog blog);

    void deleteBlog(Blog blog);

    void modifyBlog(Blog blog);
}
