package com.example.security.educare.Repo;

import com.example.security.educare.Entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepo extends JpaRepository<FileUpload ,Integer> {
}
