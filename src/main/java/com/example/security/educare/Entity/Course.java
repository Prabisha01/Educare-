package com.example.security.educare.Entity;

import com.example.security.educare.Pojo.CoursePojo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")

public  class Course{
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String coursename;

    @Column(nullable = false)
    private String duration;        //In which field or which subject he is expert

    @Column(name = "fee")
    private String fee;
}
