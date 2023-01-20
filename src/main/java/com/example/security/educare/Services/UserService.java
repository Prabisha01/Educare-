package com.example.security.educare.Services;


import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.ContactPojo;
import com.example.security.educare.Pojo.UserPojo;


import java.util.List;

public interface UserService {
    User fetchById(Integer id) ;

    String saveUser(UserPojo userPojo);
    List<User> fetchAll();

    String submitMsg(ContactPojo contactPojo);
    void deleteById(Integer id);

    UserPojo findByUserName(String email);

    String save(BlogPojo blogPojo);
    UserPojo findByEmail(String email);
    UserPojo findByPassword(String password);

}
