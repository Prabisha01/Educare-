package com.example.security.educare.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @SequenceGenerator(name = "gp_book_seq_gen", sequenceName = "gp_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    public Contact(int id, String fullname, String email, String subject, String message) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
        public Contact() {
            super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}