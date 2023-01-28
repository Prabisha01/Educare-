package com.example.security.educare.Services;

import com.example.security.educare.Entity.Course;
import com.example.security.educare.Entity.Teams;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.CoursePojo;
import com.example.security.educare.Pojo.TeamsPojo;
import com.example.security.educare.Pojo.UserPojo;

import java.util.List;

public interface CourseService {
    String saveUser(CoursePojo coursePojo);
    List<Course> fetchAll();

}
