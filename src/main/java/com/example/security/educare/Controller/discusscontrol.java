package com.example.security.educare.Controller;


import com.example.security.educare.Entity.Discuss;
import com.example.security.educare.Pojo.discuss;
import com.example.security.educare.Services.DiscussService;
import com.example.security.educare.Services.UserService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class discusscontrol {
    private final DiscussService discussService;
    private final UserService userService;

    @GetMapping("/save")
    public String saveUser(Principal principal, @Valid discuss discuss ) {
        discuss.setName1(userService.findByUsername(principal.getName()).getUserName());
        discussService.saveUser(discuss);
        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String getUserList(Model model, Principal principal) {
        model.addAttribute("discuss",new discuss());
        List<Discuss> discuss = discussService.fetchall();
//        model.addAttribute("logged",userService.findByUsername(principal.getName()));
        model.addAttribute("messageList", discuss);
        return "discussion";
    }
}
