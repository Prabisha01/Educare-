package com.example.security.educare.Pojo;

import com.example.security.educare.Entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPojo {
    private Integer id;
    private  String author;
    private  String topic;
    private  String date;
    private  String phoneNum;
    private  String content;
//    private  String img;

    public BlogPojo(Blog blog) {
        this.id=blog.getId();
        this.topic=blog.getTitle();
        this.date=blog.getDate();
        this.content=blog.getContent();

//        this.img=blog.getImg();
    }
}
