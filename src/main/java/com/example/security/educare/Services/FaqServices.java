package com.example.security.educare.Services;
import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Pojo.FaqPojo;


import java.util.List;

public interface FaqServices {
        String saveUser(FaqPojo FaqPojo);
        List<Faq> fetchAll();


}
