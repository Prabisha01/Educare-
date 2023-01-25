package com.example.security.educare.Pojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaqPojo {

    private Integer id;
    private String question;
    private String answer;

    public FaqPojo(FaqPojo user){
        this.id= user.getId();
        this.question=user.getQuestion();
        this.answer=user.getAnswer();


    }

}
