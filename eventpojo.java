package com.example.security.educare.Pojo;


import com.example.security.educare.Entity.event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // dynamic banaunw duitai pass gareko
@AllArgsConstructor
public class eventpojo {
    private Integer id;
    private String date;
    private  String content;
    public eventpojo(event event){
        this.id=event.getId();
        this.date=event.getDate();
        this.content=event.getTitle();
    }
}
