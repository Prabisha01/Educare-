package com.example.security.educare.Pojo;
import com.example.security.educare.Entity.Discuss;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class discuss {
    private int id;
    private String message;
    private String name1;
    public discuss(Discuss discuss1){
        this.id=discuss1.getId();
        this.message=discuss1.getMessage();
        this.name1=discuss1.getName1();
        
    }
}
