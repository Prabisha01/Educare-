package com.system.springboot4.controller;

import com.system.springboot4.entity.event;
import com.system.springboot4.repo.eventrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//public class Calendarcontroller {
//}
@RestController
@RequestMapping("/api")
public class Calendarcontroller {

    @Autowired
    private eventrepo eventRepository;

    @GetMapping("/events")
    public List<event> getEvents() {
//        System.out.println(eventRepository.findAll());
        return eventRepository.findAll();
    }
}
//public class Event {
//
//    private Long id;
//    private String title;
//    private LocalDateTime start;
//    private LocalDateTime end;
//    // other properties
//
//    // getters and setters
//}