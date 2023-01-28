package com.example.security.educare.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "faq")

    public class Faq{
        @Id
        @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
        @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
        private Integer id;

        @Column(name = "question" , nullable = false)
        private String question;

        @Column(name = "answer",  nullable = false)
        private String answer;

            //In which field or which subject he is expert


}
