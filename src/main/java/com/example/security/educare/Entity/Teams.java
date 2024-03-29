package com.example.security.educare.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "teams")
    public class Teams{
        @Id
        @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
        @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
        private Integer id;
        @Column(name="firstname", nullable = false)
        private String firstname;

        @Column(nullable = false)
        private String lastname;

        @Column(nullable = false,unique = true)
        private String userName;

        @Column(nullable = false)
        private String field;        //In which field or which subject he is expert


        @Column(name = "Email",nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;

        @Column(name = "mobile_no", nullable=false)
        private String mobileNo;
}
