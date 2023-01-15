package com.example.security.educare.Controller;

import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.ContactPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class homepageController {

    @GetMapping("/home")
    public String gethome() {
        return "homepage";
    }
    @GetMapping("/contact")
    public String getPage( Model model){
        model.addAttribute("contact", new ContactPojo());
        return "Contact";}

    @GetMapping("/about")
    public String getAbout() {
        return "companyProfile";
    }

    @GetMapping("/userguide")
    public String getGuide() {
        return "userguide";
    }

    @GetMapping("/viewBlog")
    public String viewUserBlog(Model model) {
        model.addAttribute("blog", new BlogPojo());
        return "redirect:/blog/list";
    }

    @GetMapping("/course")
    public String getCourse() {
        return "Course";
    }

    @GetMapping("/quiz")
    public String getquiz() {
        return "Quiz_python";
    }

}