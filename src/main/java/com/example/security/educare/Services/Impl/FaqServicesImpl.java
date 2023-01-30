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
public class FaqServicesImpl implements FaqServices {
    private  final FaqRepo faqRepo;

    @Override
    public String save(FaqPojo faqPojo) {
        Faq faq =new Faq();
        if(faqPojo.getId()!=null){
            faq.setId(faqPojo.getId());
        }
        faq.setId(faqPojo.getId());
        faq.setQuestion(faqPojo.getQuestion());
        faq.setAnswer(faqPojo.getAnswer());
        faqRepo.save(faq);
        return null;
    }


    @Override
    public List<Faq> fetchAll() {
        return this.faqRepo.findAll();

    }

    @Override
    public Faq fetchById(Integer id) {
        return faqRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    @Override
    public void deleteById(Integer id) {
        faqRepo.deleteById(id);
    }

}