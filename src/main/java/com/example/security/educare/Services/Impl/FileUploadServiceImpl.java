package com.example.security.educare.Services.Impl;

import com.example.security.educare.Entity.FileUpload;
import com.example.security.educare.Pojo.FileUploadPojo;
import com.example.security.educare.Repo.FileUploadRepo;
import com.example.security.educare.Services.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {
    private final FileUploadRepo fileUploadRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/educareimage/";

    @Override
    public FileUploadPojo savefile(FileUploadPojo fileUploadPojo) throws IOException {
        FileUpload fileUpload = new FileUpload();
        if (fileUpload.getId() != null) {
            fileUpload.setId(fileUpload.getId());
        }

        if (fileUploadPojo.getImage() != null) {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, fileUploadPojo.getImage().getOriginalFilename());
        fileNames.append(fileUploadPojo.getImage().getOriginalFilename());
        Files.write(fileNameAndPath, fileUploadPojo.getImage().getBytes());
        fileUpload.setImage(fileUploadPojo.getImage().getOriginalFilename());
    }
        fileUploadRepo.save(fileUpload);
        return new FileUploadPojo(fileUpload);
}

    @Override
    public List<FileUpload> fetchAll() {
        return fileUploadRepo.findAll();

    }
}
