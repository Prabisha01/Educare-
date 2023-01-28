package com.example.security.educare.Services;

import com.example.security.educare.Entity.Teams;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.TeamsPojo;
import com.example.security.educare.Pojo.UserPojo;

import java.util.List;

public interface TeamsServices {
    Teams fetchById(Integer id) ;

    String saveUser(TeamsPojo teamsPojo);
    List<Teams> fetchAll();

    void deleteById(Integer id);

}
