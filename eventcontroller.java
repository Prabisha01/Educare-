package com.example.security.educare.Controller;


import com.example.security.educare.Entity.event;
import com.example.security.educare.Pojo.eventpojo;
import com.example.security.educare.Services.eventservice;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class eventcontroller {
    private final eventservice eventservice;
    @GetMapping("/event")
    public String createUser(Model model) {
        model.addAttribute("obj",new eventpojo());
        return "User/event";
    }
    @PostMapping("/save")
    public String saveUser(@Valid eventpojo eventpojo, Model model) {
        eventservice.saveUser(eventpojo);
        return "redirect:/event/event"; // router ko path
    }

    @GetMapping("/update/{id}")
    public String getUserList( @PathVariable("id") Integer id,Model model) {
        event event = eventservice.fetchById(id);
        model.addAttribute("obj",new eventpojo(event));
        return "User/editevent";
    }


    @GetMapping("/delete/{id}")
    public String deleteuser(@PathVariable("id") Integer id){
        System.out.println("delete");
        eventservice.deleteById(id);
        return "redirect:/event/event";
    }
}
