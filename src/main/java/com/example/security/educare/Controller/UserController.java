package com.example.security.educare.Controller;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.ContactPojo;
import com.example.security.educare.Services.UserService;

import com.example.security.educare.Pojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ValidationAutoConfiguration validationAutoConfiguration;

    @GetMapping("/homepage")
        public String homePage() {
            return "homepage";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "signup";


        }

    @GetMapping("/course")
    public String getlland(Model model) {
        model.addAttribute("user", new UserPojo());
        return "Course";
    }


    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.fetchById(id);
        model.addAttribute("user", new UserPojo(user));
        return "/user/create";
    }


    @GetMapping("/delete/{id}")
    public String deleteuser(@PathVariable("id") Integer id) {
        System.out.println("delete");
        userService.deleteById(id);
        return "redirect:/user/list";

        }
    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userService.saveUser(userPojo);
        return "redirect:/user/list"; // router ko path
    }

    @GetMapping("/login")
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "/login";
        }

        return "redirect:user/homepage";



    }

    @GetMapping("/contact")
    public String getPage(Model model) {
        model.addAttribute("contact", new ContactPojo());
        return "Contact";
    }

    @PostMapping("/send-message")
    public String submitMessage(@Valid ContactPojo contactPojo) {
        userService.submitMsg(contactPojo);
        return "redirect:contact";
    }

    @GetMapping("/viewBlog")
    public String viewUserBlog(Model model) {
        model.addAttribute("blog", new BlogPojo());
        return "blog";
    }
    @GetMapping("/about")
    public String getAbout() {
        return "companyProfile";
    }



}










