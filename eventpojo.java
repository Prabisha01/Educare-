package com.system.springboot4.pojo;

import com.system.springboot4.entity.event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // dynamic banaunw duitai pass gareko
@AllArgsConstructor
public class eventpojo {
    private Integer eventid;
    private String date;
    private  String content;
    public eventpojo(event event){
        this.eventid=event.getEventid();
        this.date=event.getDate();
        this.content=event.getTitle();
    }
}
