package com.example.security.educare.Repo;

import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface BlogRepo extends JpaRepository<Blog, Integer> {
    Optional<Blog> findBlogByTitle(String answer);
}
