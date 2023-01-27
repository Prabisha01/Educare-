package com.system.springboot4.controller;

import com.system.springboot4.entity.Discuss;
import com.system.springboot4.pojo.discuss;
import com.system.springboot4.services.DiscussService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class discusscontrol {
    private final DiscussService discussService;

    @GetMapping("/save")
    public String saveUser(Model model, @Valid discuss discuss ) {
        discussService.saveUser(discuss);
        List<Discuss> discuss1 = discussService.fetchall();
        model.addAttribute("messageList", discuss1);
        return "/User/discussion";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        model.addAttribute("discuss",new discuss());
        List<Discuss> discuss = discussService.fetchall();
        model.addAttribute("messageList", discuss);
        return "/User/discussion";

    }
}
