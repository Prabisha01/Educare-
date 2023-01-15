package com.example.security.educare.Services;


import com.example.security.educare.Entity.Contact;
import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.ContactPojo;
import com.example.security.educare.Pojo.FaqPojo;
import com.example.security.educare.Pojo.UserPojo;


import java.util.List;

public interface UserService {


    abstract User fetchById(Integer id);

    String saveUser(UserPojo userPojo);
    List<User> fetchAll();

    String submitMsg(ContactPojo contactPojo);
    void deleteById(Integer id);



    User findByEmail(String email);
    String save(BlogPojo blogPojo);


    String save(FaqPojo faqPojo);


    UserPojo findByPassword(String password);

    List<Contact> fetchAllContact();

    Contact CfetchById(Integer id);
    void CdeleteById(Integer id);

    void processPasswordResetRequest(String email);

    void sendEmail();

    String updateResetPassword(String email);
}
