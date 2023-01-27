package com.system.springboot4.services.impl;

import com.system.springboot4.entity.User;
import com.system.springboot4.entity.event;
import com.system.springboot4.pojo.eventpojo;
import com.system.springboot4.repo.eventrepo;
import com.system.springboot4.services.eventservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class eventserviceimpl implements eventservice {
    private final eventrepo eventrepo;
    @Override
    public String saveUser(eventpojo eventpojo) {
        System.out.println("vayo");
        event event=new event();
        event.setDate(eventpojo.getDate());
        event.setTitle(eventpojo.getContent());
        eventrepo.save(event);
        System.out.println("not created");
        return "created";
    }
    public List<event> fetchAll() {
//        user vanni table bata data fetch garxw
        return eventrepo.findAll();
    }
}
