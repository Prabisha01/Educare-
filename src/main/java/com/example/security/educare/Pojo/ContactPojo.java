package com.example.security.educare.Pojo;


import com.example.security.educare.Entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContactPojo {

    private Integer id;
    private  String fullname;
    private String email;
    private  String subject;
    private  String message;

    public ContactPojo(Contact contact) {
        this.id=contact.getId();
        this.fullname=contact.getFullname();
        this.email=contact.getEmail();
        this.subject=contact.getSubject();
        this.message=contact.getMessage();
    }
}
