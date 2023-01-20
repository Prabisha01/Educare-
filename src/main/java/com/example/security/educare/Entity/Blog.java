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
@Table(name="blog")
public class Blog {
    @Id
    @SequenceGenerator(name = "gp_book_seq_gen", sequenceName = "gp_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;


    @Column(name = "content")
    private String content;



}