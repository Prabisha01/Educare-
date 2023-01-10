package com.example.security.educare.Controller;
import com.example.security.educare.Services.UserService;

import com.example.security.educare.UserPojo.ContactPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/register")
    public String getPage(){
        return "register";
    }


    @GetMapping("/contact")
    public String sendMsg (Model model){
    model.addAttribute("ContactPojo", new ContactPojo());
    return "Contact";
    }

}





