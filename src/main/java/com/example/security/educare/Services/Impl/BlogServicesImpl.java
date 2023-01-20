package com.example.security.educare.Services.Impl;


import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Repo.BlogRepo;
import com.example.security.educare.Services.BlogServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServicesImpl implements BlogServices {
    private  final BlogRepo blogRepo;

    @Override
    public String save(BlogPojo blogPojo) {
        Blog blog =new Blog();
        if(blogPojo.getId()!=null){
            blog.setId(blogPojo.getId());
        }
        blog.setAuthor(blogPojo.getAuthor());
        blog.setDate(blogPojo.getDate());
        blog.setContent(blogPojo.getContent());
//        blog.setImg(blogPojo.getImg());
        blogRepo.save(blog);
        return null;
    }

    @Override
    public List<Blog> fetchAll() {
        return blogRepo.findAll();

    }

    @Override
    public Blog fetchById(Integer id) {
        return blogRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    @Override
    public void deleteById(Integer id) {
        blogRepo.deleteById(id);
    }

}