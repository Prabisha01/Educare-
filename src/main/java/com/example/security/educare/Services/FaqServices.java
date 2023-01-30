package com.example.security.educare.Services;

import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Pojo.FaqPojo;

import java.util.List;

public interface FaqServices {
    String save(FaqPojo faqPojo);



    List<Faq> fetchAll();

    Faq fetchById(Integer id);
    void deleteById(Integer id);
}
