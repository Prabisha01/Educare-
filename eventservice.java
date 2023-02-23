package com.example.security.educare.Services;


import com.example.security.educare.Entity.event;
import com.example.security.educare.Pojo.eventpojo;

import java.util.List;

public interface eventservice {
    List<event> fetchAll();
    String saveUser(eventpojo eventpojo);

//    event fetchById(Integer id);

    event fetchById(Integer id);

//    void saveTitle(eventpojo eventpojo);

    void deleteById(Integer id);
}
