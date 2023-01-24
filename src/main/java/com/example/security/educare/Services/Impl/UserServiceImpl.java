
    package com.example.security.educare.Services.Impl;

    import com.example.security.educare.Entity.Contact;
    import com.example.security.educare.Entity.User;
    import com.example.security.educare.Pojo.BlogPojo;
    import com.example.security.educare.Pojo.ContactPojo;
    import com.example.security.educare.Repo.ContactRepo;
    import com.example.security.educare.Repo.EmailCredRepo;
    import com.example.security.educare.Repo.UserRepo;
    import com.example.security.educare.Services.UserService;
    import com.example.security.educare.Pojo.UserPojo;
    import com.example.security.educare.exception.AppException;
    import freemarker.template.Configuration;
    import freemarker.template.Template;
    import jakarta.mail.internet.MimeMessage;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.http.HttpStatus;
    import org.springframework.mail.javamail.JavaMailSender;
    import org.springframework.mail.javamail.MimeMessageHelper;
    import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.stereotype.Service;
    import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

    import java.nio.charset.StandardCharsets;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {
        public final ContactRepo contactRepo;
        public final UserRepo userRepo;
        private final JavaMailSender getJavaMailSender;
        private final EmailCredRepo emailCredRepo;
        private final ThreadPoolTaskExecutor taskExecutor;

        @Autowired
        @Qualifier("emailConfigBean")
        private Configuration emailConfig;


        @Override
        public User fetchById(Integer id) {
            return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        }

        @Override
        public String saveUser(UserPojo userPojo) {
            System.out.println("userserviceimplsave");
            User user = new User();
            user.setUserName(userPojo.getUserName());
            user.setEmail(userPojo.getEmail());
            user.setMobileNo(userPojo.getMobileNo());

            user.setFirstname(userPojo.getFirstname());
            user.setLastname(userPojo.getLastname());

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodePassword = passwordEncoder.encode(userPojo.getPassword());
            user.setPassword(encodePassword);
            userRepo.save(user);
            return "created";
        }

        @Override

        public List<User> fetchAll() {
            return userRepo.findAll();
        }

        @Override
        public String submitMsg(ContactPojo contactPojo) {
            Contact contact = new Contact();
            contact.setFullname(contactPojo.getFullname());
            contact.setEmail(contactPojo.getEmail());
            contact.setSubject(contactPojo.getSubject());
            contact.setMessage(contactPojo.getMessage());
            contactRepo.save(contact);
            return "submit";
        }


        @Override
        public void deleteById(Integer id) {
            userRepo.deleteById(id);
        }

        @Override
        public UserPojo findByUserName(String user_name) {
            User user = userRepo.findByUserName(user_name)
                    .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
            return new UserPojo(user);
        }

        @Override
        public String save(BlogPojo blogPojo) {
            return null;
        }

        @Override
        public UserPojo findByEmail(String email) {
            return null;
        }

        @Override
        public UserPojo findByPassword(String password) {
            return null;
        }
        @Override
        public void sendEmail() {
            try {
                Map<String, String> model = new HashMap<>();

                MimeMessage message = getJavaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

                Template template = emailConfig.getTemplate("emailTemp.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

                mimeMessageHelper.setTo("sendfrom@yopmail.com");
                mimeMessageHelper.setText(html, true);
                mimeMessageHelper.setSubject("Registration");
                mimeMessageHelper.setFrom("sendTo@yopmail.com");

                taskExecutor.execute(new Thread() {
                    public void run() {
                        getJavaMailSender.send(message);
                    }
                });
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

    }





