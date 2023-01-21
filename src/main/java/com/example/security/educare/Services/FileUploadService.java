package com.example.security.educare.Services;

import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Entity.FileUpload;
import com.example.security.educare.Pojo.FileUploadPojo;

import java.io.IOException;
import java.util.List;

public interface FileUploadService {

    FileUploadPojo savefile(FileUploadPojo FileUploadPojo) throws IOException;

    List<FileUpload> fetchAll();

}
