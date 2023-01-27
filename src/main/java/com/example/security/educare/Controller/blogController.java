package com.example.security.educare.Controller;

import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.FaqPojo;
import com.example.security.educare.Services.BlogServices;
import com.example.security.educare.Services.FaqServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class blogController {
  private  final BlogServices blogServices;


    @GetMapping("/addBlog")
    public String createBlog(Model model) {
        model.addAttribute("blog", new BlogPojo());
        return "/adminBlog";
    }


    @PostMapping("/save")
    public String saveBlog(@Valid BlogPojo blogPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:blog/addBlog";
        }

        blogServices.save(blogPojo);
        redirectAttributes.addFlashAttribute("successMsg", "Image saved successfully");

        return "redirect:/blog/list";
    }

    @GetMapping("/list")
    public String addBlog( Model model) {
        List<Blog> blogs = blogServices.fetchAll();
        model.addAttribute("bloglist", blogs.stream().map(blog ->
                Blog.builder()
                        .id(blog.getId())
                        .title(blog.getTitle())
                        .author(blog.getAuthor())
                        .content(blog.getContent())
                        .date(blog.getDate())
                        .imageBase64(getImageBase64(blog.getImage()))
                        .build()

        ));
        return "Blog";
    }


    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/educareimage/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }


}
