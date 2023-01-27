package com.system.springboot4.controller;
import com.system.springboot4.entity.User;
import com.system.springboot4.entity.event;
import com.system.springboot4.pojo.UserPojo;
import com.system.springboot4.pojo.eventpojo;
import com.system.springboot4.repo.UserRepo;
import com.system.springboot4.services.UserService;
import com.system.springboot4.services.eventservice;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class eventcontroller {
    private final eventservice eventservice;
    @GetMapping("/event")
    public String createUser(Model model) {
        model.addAttribute("obj",new eventpojo());
        System.out.println("eventcontroller");
        return "User/event";

    }
    @PostMapping("/save")
    public String saveUser(@Valid eventpojo eventpojo,Model model) {
        eventservice.saveUser(eventpojo);
        model.addAttribute("obj",new eventpojo());
        System.out.println("usercontroller5");
        return "User/event"; // router ko path
    }
    @GetMapping("/update")
    public String getUserList(Model model) {
        List<event> event = eventservice.fetchAll();
        model.addAttribute("eventList", event);
        System.out.println("usercontroller2");
        return ("/User/index");

    }
}
