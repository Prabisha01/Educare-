package com.example.security.educare.Controller;

import com.example.security.educare.Entity.Course;
import com.example.security.educare.Pojo.CoursePojo;
import com.example.security.educare.Services.CourseService;
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
@RequestMapping("/course")
public class coursecontroller {
    private final CourseService courseService;


    @GetMapping("/create")
    public String createCourse(Model model) {
        model.addAttribute("course", new CoursePojo());
        return "Addcourse";
    }

    @PostMapping("/save")
    public String saveUser(@Valid CoursePojo coursePojo) {
        courseService.saveUser(coursePojo);
        return "Course";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Course> course = courseService.fetchAll();
        model.addAttribute("courseList", course);
        return "Course";
    }

}
