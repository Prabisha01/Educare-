package com.example.security.educare.Repo;
import com.example.security.educare.Entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface FaqRepo extends JpaRepository<Faq, Integer> {
//    Optional<Faq> findfaqByAnswer(String answer);
}