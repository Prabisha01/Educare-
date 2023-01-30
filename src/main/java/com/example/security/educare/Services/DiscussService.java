package com.example.security.educare.Services;

import com.example.security.educare.Entity.Discuss;
import com.example.security.educare.Pojo.discuss;

import java.util.List;

public interface DiscussService {
    String saveUser(discuss discuss);
    List<Discuss> fetchall();
}
