package com.example.security.educare.Services;


import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.UserPojo;


import java.util.List;

public interface UserService {
    User fetchById(Integer id) ;

    String saveUser(UserPojo userPojo);
    List<User> fetchAll();

    void deleteById(Integer id);

    UserPojo findByUserName(String email);
}
