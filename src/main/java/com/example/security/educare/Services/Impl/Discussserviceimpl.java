package com.example.security.educare.Services.Impl;

import com.example.security.educare.Entity.Discuss;
import com.example.security.educare.Pojo.discuss;
import com.example.security.educare.Repo.discussrepo;
import com.example.security.educare.Services.DiscussService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Discussserviceimpl implements DiscussService {
    private final com.example.security.educare.Repo.discussrepo discussrepo;

    @Override
    public String saveUser(discuss discuss) {
        Discuss discuss1=new Discuss();
        discuss1.setMessage(discuss.getMessage());
        discussrepo.save(discuss1);
        return "complete";
    }

    @Override
    public List<Discuss> fetchall() {
        return discussrepo.findAll();
    }
}
