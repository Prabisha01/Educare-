package com.example.security.educare.Services.Impl;

import com.example.security.educare.Entity.Course;
import com.example.security.educare.Pojo.CoursePojo;

import com.example.security.educare.Repo.CourseRepo;

import com.example.security.educare.Services.CourseService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    public final CourseRepo courseRepo;

            public String saveUser(CoursePojo coursePojo) {
                Course user=new Course();
                user.setCoursename(coursePojo.getCourseName());
                user.setDuration(coursePojo.getDuration());
                user.setFee(coursePojo.getFee());
                courseRepo.save(user);
                return "created";

            }

            @Override
            public List<Course> fetchAll() {
                return courseRepo.findAll();
            }
        };