package com.example.security.educare.Services;


import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Pojo.BlogPojo;

import java.util.List;

    public interface BlogServices {
        String save(BlogPojo blogPojo);
        List<Blog> fetchAll();

        Blog fetchById(Integer id);
        void deleteById(Integer id);
    }

