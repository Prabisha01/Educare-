package com.example.security.educare.Pojo;

import com.example.security.educare.Entity.Discuss;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Pojo backend ko validation ko laagi ekdamai important

@Getter
@Setter
@NoArgsConstructor // dynamic banaunw duitai pass gareko
@AllArgsConstructor

public class discuss {
    private int id;
    private String message;
    public discuss(Discuss discuss1){
        this.id=discuss1.getId();
        this.message=discuss1.getMessage();
    }
}
