package com.example.helloblog.repository;

import com.example.helloblog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Integer> {
    List<Blog> findAll();
    Blog findBlogById(Integer id);



}
