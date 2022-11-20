package com.example.helloblog.controller;

import com.example.helloblog.domain.Blog;
import com.example.helloblog.repository.BlogDao;
import com.example.helloblog.service.BlogListService;
import com.example.helloblog.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogListService blogListService;

    @RequestMapping("/findAll")
    public Result<List<Blog>> blogList() {
        List<Blog> blogList = blogListService.findAllBlog();
        if (!blogList.isEmpty()) {
            return Result.success(blogList);
        } else {
            return Result.error("423", "访问的资源不存在！");
        }

    }

    @RequestMapping("/findBlog/{id}")
    public Result<Blog> blogDetail(@PathVariable(name = "id") String id) {
        Blog blog = blogListService.findBlogById(Integer.parseInt(id));
        if (blog != null) {
            return Result.success(blog);
        } else {
            return Result.error("423", "访问的资源不存在！");
        }

    }

    @RequestMapping("/addBlog")
    public Result<Blog> addBlog(Blog blog) {
        if (blog != null) {
            Blog b = blogListService.addBlog(blog);
            return Result.success(blog);
        } else {
            return Result.error("423", "访问的资源不存在！");
        }

    }
@RequestMapping("/delete")
    public Result<Blog> deleteBlog(@RequestParam String id) {
        Blog blog = blogListService.findBlogById(Integer.parseInt(id));
        if (blog != null) {
            blogListService.deleteBlog(blog);
            return Result.success();
        } else {
            return Result.error("423", "删除失败！");
        }

    }
    @RequestMapping("/modify")
    public  Result<Blog> modifyBlog(Blog blog) {
        if (blog.getId() != null) {
            blogListService.modifyBlog(blog);
            return Result.success();
        } else {
            return Result.error("423", "修改失败！");
        }

    }
}
