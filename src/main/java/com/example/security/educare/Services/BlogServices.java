package com.example.security.educare.Services;


import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Pojo.BlogPojo;

import java.io.IOException;
import java.util.List;

    public interface BlogServices {
        BlogPojo saveBlog(BlogPojo blogPojo)throws IOException;

        List<Blog> fetchAll();

        Blog fetchById(Integer id);
        void deleteById(Integer id);
    }
