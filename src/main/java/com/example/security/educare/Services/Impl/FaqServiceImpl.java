package com.example.security.educare.Services.Impl;


import com.example.security.educare.Entity.Faq;

import com.example.security.educare.Pojo.FaqPojo;

import com.example.security.educare.Repo.FaqRepo;

import com.example.security.educare.Services.FaqServices;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FaqServiceImpl  implements FaqServices {
    private  final FaqRepo faqRepo;

    @Override
    public String saveUser(FaqPojo faqPojo) {
        Faq user = new Faq();
        user.setQuestion(faqPojo.getQuestion());
        user.setAnswer(faqPojo.getAnswer());
        faqRepo.save(user);
        return "created";
    }

    @Override
    public List<Faq> fetchAll() {
        return faqRepo.findAll();
    }


}
