package com.example.security.educare.Controller;

import com.example.security.educare.Entity.Teams;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.TeamsPojo;
import com.example.security.educare.Pojo.UserPojo;
import com.example.security.educare.Services.TeamsServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teams")
public class teamcontroller {
    private final TeamsServices teamsServices;


    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("teams", new TeamsPojo());
        return "Addteams";
    }

    @PostMapping("/save")
    public String saveUser(@Valid TeamsPojo teamsPojo) {
        teamsServices.saveUser(teamsPojo);
        return "teamList";   //Write the pop box of sucess message
    }

    @GetMapping("/list")    //This is for admin side to view teams and update delete
    public String getUserList(Model model) {
        List<Teams> teams = teamsServices.fetchAll();
        model.addAttribute("teamsList", teams);
        return "teamList";
    }

    @GetMapping("/teams") //This is for user side
    public String getTeamsList(Model model) {
        List<Teams> teams = teamsServices.fetchAll();
        model.addAttribute("teamsList", teams);
        return "Teams";
    }




    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Teams teams = teamsServices.fetchById(id);
        model.addAttribute("teams", new TeamsPojo(teams));
        return "/teams/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteuser(@PathVariable("id") Integer id) {
        System.out.println("delete");
        teamsServices.deleteById(id);
        return "redirect:/teams/list";

    }

}
