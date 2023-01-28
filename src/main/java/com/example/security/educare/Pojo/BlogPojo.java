package com.example.security.educare.Pojo;

import com.example.security.educare.Entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPojo {
    private Integer id;
    private  String author;
    private  String title;
    private  String date;
    private  String phoneNum;
    private  String content;
   private MultipartFile img;


    public BlogPojo(Blog blog) {
        this.id=blog.getId();
        this.author = blog.getAuthor();
        this.title=blog.getTitle();
        this.date=blog.getDate();
        this.content=blog.getContent();

    }
}
