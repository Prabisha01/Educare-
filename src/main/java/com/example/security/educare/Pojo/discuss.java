package com.system.springboot4.pojo;
import com.system.springboot4.entity.Discuss;
import com.system.springboot4.entity.User;
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
