package com.example.security.educare.Pojo;
import com.example.security.educare.Entity.Faq;
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

    public FaqPojo(Faq faq){
        this.id= faq.getId();
        this.question=faq.getQuestion();
        this.answer=faq.getAnswer();


    }


}
