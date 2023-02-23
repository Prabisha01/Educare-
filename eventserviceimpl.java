package com.example.security.educare.Services.Impl;


import com.example.security.educare.Entity.event;
import com.example.security.educare.Pojo.eventpojo;
import com.example.security.educare.Repo.eventrepo;
import com.example.security.educare.Services.eventservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class eventserviceimpl implements eventservice {
    private final eventrepo eventrepo;
    @Override
    public String saveUser(eventpojo eventpojo) {


        event event;
        if (eventpojo.getId()!=null){
            event=eventrepo.findById(eventpojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));;
        }else {
            event=new event();
        }
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
    @Override
    public event fetchById(Integer id) {
        return eventrepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }



    @Override
    public void deleteById(Integer id) {
        eventrepo.deleteById(id);
    }
}
