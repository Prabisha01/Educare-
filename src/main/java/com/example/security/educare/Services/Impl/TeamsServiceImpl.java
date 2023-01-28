package com.example.security.educare.Services.Impl;

import com.example.security.educare.Entity.Teams;
import com.example.security.educare.Pojo.TeamsPojo;
import com.example.security.educare.Repo.TeamsRepo;
import com.example.security.educare.Services.TeamsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamsServiceImpl implements TeamsServices {
public final TeamsRepo teamsRepo;



    @Override
    public String saveUser(TeamsPojo teamsPojo) {
        Teams user = new Teams();
        user.setUserName(teamsPojo.getUserName());
        user.setEmail(teamsPojo.getEmail());
        user.setMobileNo(teamsPojo.getMobileNo());

        user.setFirstname(teamsPojo.getFirstname());
        user.setLastname(teamsPojo.getLastname());
        user.setField(teamsPojo.getField());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(teamsPojo.getPassword());
        user.setPassword(encodePassword);
        teamsRepo.save(user);
        return "created";
    }

    @Override
    public Teams fetchById(Integer id) {
        return null;
    }

    @Override
    public List<Teams> fetchAll() {
        return teamsRepo.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        teamsRepo.deleteById(id);
    }


}
