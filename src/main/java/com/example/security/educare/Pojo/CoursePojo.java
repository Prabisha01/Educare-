package com.example.security.educare.Pojo;

import com.example.security.educare.Entity.Course;
import com.example.security.educare.Entity.Teams;
import com.example.security.educare.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursePojo {

    private Integer id;
    private String courseName;
    private String duration;
    private String fee;

    public CoursePojo(Course user){
        this.id= user.getId();
        this.courseName=user.getCoursename();
        this.duration=getDuration();
        this.fee=user.getFee();


    }


}
