package com.example.security.educare.Pojo;

import com.example.security.educare.Entity.FileUpload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadPojo {

    private Integer id;

    private MultipartFile image;

    public FileUploadPojo (FileUpload fileUpload){
        this.id= fileUpload.getId();
    }
}
