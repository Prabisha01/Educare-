package com.example.security.educare.Services.Impl;


import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Repo.BlogRepo;
import com.example.security.educare.Services.BlogServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BlogServicesImpl implements BlogServices {
    private final BlogRepo blogRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/educareimage/";


    @Override
    public BlogPojo saveBlog(BlogPojo blogPojo) throws IOException {
        Blog blog = new Blog();
        if (blogPojo.getId() != null) {
            blog.setId(blogPojo.getId());
        }
        blog.setTitle(blogPojo.getTitle());
        blog.setAuthor(blogPojo.getAuthor());
        blog.setContent(blogPojo.getContent());
        blog.setDate(blogPojo.getDate());

        if(blogPojo.getImage()!=null){
//            StringBuilder fileNames = new StringBuilder();
//            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, blogPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, blogPojo.getImage().getBytes());

            blog.setImage(blogPojo.getImage().getOriginalFilename());
        }
        blogRepo.save(blog);
        return new BlogPojo(blog);
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