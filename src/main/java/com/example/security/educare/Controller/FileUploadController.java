package com.example.security.educare.Controller;

import com.example.security.educare.Entity.Blog;
import com.example.security.educare.Entity.FileUpload;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.FileUploadPojo;
import com.example.security.educare.Services.FileUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fileUpload")
public class FileUploadController {

    private final FileUploadService fileUploadService;
    @GetMapping("/file")
    public String getAdminProfile(Model model) {
        model.addAttribute("files", new BlogPojo());
        return "fileuplode";

    }
    @PostMapping("/saveFile")
    public String saveMovie(@Valid FileUploadPojo fileUploadPojo, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/fileUpload/file";
        }
        fileUploadService.savefile(fileUploadPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");
        return "redirect:/admin/dashboard";
    }


    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }

    @GetMapping("/pastQuestions")
    public String displayBlog( Model model) {
        List<FileUpload> fileUploads = fileUploadService.fetchAll();
        model.addAttribute("fileuploads", fileUploads.stream().map(fileUpload ->
                Blog.builder()
                        .id(fileUpload.getId())
                        .imageBase64(getImageBase64(fileUpload.getImage()))
                        .build()
        ));
        return "PastQuestions";
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/educareimage/";
        File file = new File(filePath + fileName);
        byte[] bytes ;
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }
}