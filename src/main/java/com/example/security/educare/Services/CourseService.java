package com.example.security.educare.Services;

import com.example.security.educare.Entity.Course;
import com.example.security.educare.Entity.Teams;
import com.example.security.educare.Pojo.CoursePojo;


import java.util.List;

public interface CourseService {

    Course fetchById(Integer id) ;
    String saveUser(CoursePojo coursePojo);
    List<Course> fetchAll();
    void deleteById(Integer id);

}
