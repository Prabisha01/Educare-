package com.example.security.educare.Controller;

import com.example.security.educare.Entity.Faq;

import com.example.security.educare.Pojo.FaqPojo;

import com.example.security.educare.Services.FaqServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequiredArgsConstructor
@RequestMapping("/faq")
public class faqController {
    private final FaqServices faqServices;


    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("faq", new FaqPojo());
        return "Addfreq";
    }

    @PostMapping("/save")
    public String saveUser(@Valid FaqPojo faqPojo) {
        faqServices.saveUser(faqPojo);
        return "Frequently";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Faq> faqs = faqServices.fetchAll();
        model.addAttribute("frequentList", faqs);
        return "Frequently";
    }

}

