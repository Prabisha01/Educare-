package com.system.springboot4.repo;

import com.system.springboot4.entity.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface discussrepo extends JpaRepository<Discuss ,Integer> {
}
