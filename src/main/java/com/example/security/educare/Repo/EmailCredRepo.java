package com.example.security.educare.Repo;

import com.example.security.educare.Entity.EmailCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailCredRepo extends JpaRepository<EmailCredentials, Integer> {
    @Query(value = "select * from email_credentials where active='true' ORDER BY date desc limit 1",nativeQuery = true)
    EmailCredentials findOneByActive();
}
