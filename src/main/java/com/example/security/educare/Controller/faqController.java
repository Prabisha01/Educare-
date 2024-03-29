package com.example.security.educare.Controller;

import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Pojo.FaqPojo;
import com.example.security.educare.Services.FaqServices;
import jakarta.validation.Valid;
import lombok.Builder;
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
@RequestMapping("/faq")
public class faqController {
    private final FaqServices faqServices;


    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("faq", new FaqPojo());
        return "AddFreq";
    }

    @PostMapping("/save")
    public String saveUser(@Valid FaqPojo faqPojo) {
        faqServices.save(faqPojo);
        return "redirect:/faq/list";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Faq> faqs = faqServices.fetchAll();
        model.addAttribute("faqlist", faqs);
        return "faqtable";
    }

    @GetMapping("/view")
    public String getViewList(Model model) {
        List<Faq> faqs = faqServices.fetchAll();
        model.addAttribute("faqlist", faqs);
        return "Frequently";
    }

    @GetMapping("/editFaq/{id}")
    public String editFaq(@PathVariable("id") Integer id, Model model) {
        Faq faq = faqServices.fetchById(id);
        model.addAttribute("faqlist", new FaqPojo(faq));
        return "AddFreq";
    }


    @GetMapping("/deleteFaq/{id}")
    public String deleteFaq(@PathVariable("id") Integer id) {
        faqServices.deleteById(id);
        return "redirect:/faq/list";
    }


}

