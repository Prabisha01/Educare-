package com.example.security.educare.Controller;

import ch.qos.logback.core.model.Model;
import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Pojo.BlogPojo;

import com.example.security.educare.Services.BlogServices;
import com.example.security.educare.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class admincontroller {

    @Controller
    @RequiredArgsConstructor
    @RequestMapping("/admin")
    public class AdminController {
        private final UserService userService;
        private final BlogServices blogService;


        @GetMapping("/adminblogpage")
        public String getPage() {
            return "admin";
        }


        @GetMapping("/bloglist")
        public String getBlogList(Model model) {
            List<Blog> blogs = blogService.fetchAll();
            return "adminBlogPage";
        }

        @GetMapping("/newblog")
        public String AddBlog(Model model) {

            return "admin_blog";
        }

        @PostMapping("/saveblog")
        public String saveBlog(@Valid BlogPojo blogPojo) {
            blogService.save(blogPojo);
            return "redirect:/admin/bloglist";
        }




        @GetMapping("/deleteblog/{id}")
        public String deleteBlog(@PathVariable("id") Integer id) {
            blogService.deleteById(id);
            return "redirect:/admin/bloglist";
        }
    }
}
