package com.example.security.educare.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="firstname", nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false,unique = true)
    private String userName;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column(name = "mobile_no")
    private String mobileNo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {return this.userName;}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

