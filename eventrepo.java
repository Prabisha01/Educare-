package com.system.springboot4.repo;
import com.system.springboot4.entity.event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface eventrepo extends JpaRepository<event,Integer> {


}
