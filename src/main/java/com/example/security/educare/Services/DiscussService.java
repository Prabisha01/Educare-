package com.system.springboot4.services;

import com.system.springboot4.entity.Discuss;
import com.system.springboot4.pojo.UserPojo;
import com.system.springboot4.pojo.discuss;

import java.util.List;

public interface DiscussService {
    String saveUser(discuss discuss);
    List<Discuss> fetchall();
}
