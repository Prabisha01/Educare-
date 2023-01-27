package com.system.springboot4.services;

import com.system.springboot4.entity.User;
import com.system.springboot4.entity.event;
import com.system.springboot4.pojo.UserPojo;
import com.system.springboot4.pojo.eventpojo;

import java.util.List;

public interface eventservice {
    List<event> fetchAll();
    String saveUser(eventpojo eventpojo);
}
