package com.example.helloblog.service.serviceImpI;

import com.example.helloblog.domain.Blog;
import com.example.helloblog.domain.User;
import com.example.helloblog.repository.BlogDao;
import com.example.helloblog.service.BlogListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogListServiceImpI implements BlogListService {
    @Resource
    private BlogDao blogDao;

    @Override
    public List<Blog> findAllBlog() {

        return blogDao.findAll();
    }

    @Override
    public Blog findBlogById(Integer id) {
        return blogDao.findBlogById(id);
    }

    @Override
    public Blog addBlog(Blog blog) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        blog.setBtime(sdf.format(now));
        return blogDao.save(blog);


    }

    @Override
    public void deleteBlog(Blog blog) {
        blogDao.delete(blog);
    }

    @Override
    public void modifyBlog(Blog blog) {
        Integer curId = blog.getId();
        blogDao.deleteById(curId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        blog.setBtime(sdf.format(now));
        blog.setId(curId-1);
        blogDao.save(blog);
    }
}