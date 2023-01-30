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
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/FinalEducareProject/educareimage/";


    @Override
    public BlogPojo save(BlogPojo blogPojo) throws IOException {
        Blog blog;
        if (blogPojo.getId() != null) {
            blog = blogRepo.findById(blogPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            blog = new Blog();
        }
        blog.setAuthor(blogPojo.getAuthor());
        blog.setTitle(blogPojo.getTitle());
        blog.setDate(blogPojo.getDate());
        blog.setContent(blog.getContent());

        if(blogPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, blogPojo.getImage().getOriginalFilename());
            fileNames.append(blogPojo.getImage().getOriginalFilename());
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
}