//package com.system.springboot4.services.impl;
//
//import com.system.springboot4.entity.Discuss;
//import com.system.springboot4.pojo.discuss;
//import com.system.springboot4.repo.discussrepo;
//import com.system.springboot4.services.DiscussService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class Discussserviceimpl implements DiscussService {
//    private final discussrepo discussrepo;
//
//    @Override
//    public String saveUser(discuss discuss) {
//        Discuss discuss1=new Discuss();
//        discuss1.setMessage(discuss.getMessage());
//        discussrepo.save(discuss1);
//        return "complete";
//    }
//
//    @Override
//    public List<Discuss> fetchall() {
//        return discussrepo.findAll();
//    }
//}
