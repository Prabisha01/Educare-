package com.example.security.educare;

import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Repo.BlogRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogRepositoryTest {

    @Autowired
    private BlogRepo blogRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveBlogTest() {

        Blog blog = Blog.builder()
                .author("beesha")
                .title("Educare")
                .content("blog bloh")
                .build();

        blogRepo.save(blog);

        Assertions.assertThat(blog.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getBlogTest() {

        Blog blog = Blog.builder()

                .author("beesha")
                .title("Educare")
                .content("blog bloh")
                .build();

        blogRepo.save(blog);

        Blog blogCreated = blogRepo.findById(blog.getId()).get();
        Assertions.assertThat(blogCreated.getId()).isEqualTo(blog.getId());

    }

    @Test
    @Order(3)
    public void getListOfBlogTest(){
        Blog blog = Blog.builder()

                .author("beesha")
                .title("Educare")
                .content("blog bloh")
                .build();

        blogRepo.save(blog);
        List<Blog> User = blogRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateBlogTest(){

        Blog blog = Blog.builder()

                .author("beesha")
                .title("Educare")
                .content("blog bloh")
                        .build();

        blogRepo.save(blog);

        Blog blog1  = blogRepo.findById(blog.getId()).get();

        blog1.setTitle("Educare");

        Blog blogUpdated  = blogRepo.save(blog);

        Assertions.assertThat(blogUpdated.getTitle()).isEqualTo("Educare nepal");

    }

    @Test
    @Order(5)
    public void deleteBlogTest(){

        Blog blog = Blog.builder()

                .author("beesha")
                .title("Educare")
                .content("blog bloh")
                .build();

        blogRepo.save(blog);


        Blog blog1 = blogRepo.findById(blog.getId()).get();
        blogRepo.delete(blog1);

        Blog blog2 = null;
        Optional<Blog> optionalBlog = blogRepo.findBlogByTitle("educare");
        if(optionalBlog.isPresent()){
            blog2 = optionalBlog.get();
        }

        Assertions.assertThat(blog2).isNull();
    }

}