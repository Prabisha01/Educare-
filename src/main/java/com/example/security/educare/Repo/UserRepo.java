package com.example.security.educare.Repo;

import com.example.security.educare.Entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value="select * from users where email=?1", nativeQuery = true)
    Optional<User> findByUserName(String email);


}
