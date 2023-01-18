package com.example.security.educare.Pojo;

import com.example.security.educare.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

    private Integer id;
    private String userName;
    private String email;
    private String mobileNo;
    private String password;
    private String firstname;
    private String lastname;

    public UserPojo(User user){
        this.id= user.getId();
        this.userName=user.getUsername();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.mobileNo=user.getMobileNo();
        this.firstname=user.getFirstname();
        this.lastname=user.getLastname();



    }


}
