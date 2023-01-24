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

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class admincontroller {

    private final UserService userService;
    private final BlogServices blogServices;


}