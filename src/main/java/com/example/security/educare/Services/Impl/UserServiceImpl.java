
    package com.example.security.educare.Services.Impl;

    import com.example.security.educare.Entity.Contact;
    import com.example.security.educare.Entity.Faq;
    import com.example.security.educare.Entity.User;
    import com.example.security.educare.Pojo.BlogPojo;
    import com.example.security.educare.Pojo.ContactPojo;
    import com.example.security.educare.Pojo.FaqPojo;
    import com.example.security.educare.Repo.ContactRepo;
    import com.example.security.educare.Repo.FaqRepo;
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

    import org.springframework.mail.SimpleMailMessage;
    import org.springframework.mail.javamail.JavaMailSender;
    import org.springframework.mail.javamail.MimeMessageHelper;
    import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.stereotype.Service;
    import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

    import java.nio.charset.StandardCharsets;
    import java.util.*;


    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {
        public final ContactRepo contactRepo;
        public final UserRepo userRepo;
        public final FaqRepo faqRepo;
        private final JavaMailSender mailSender;
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
            return null;
        }

        @Override
        public void deleteById(Integer id) {

        }


        public String save(FaqPojo faqPojo) {
            Faq faq =new Faq();
            if(faqPojo.getId()!=null){
                faq.setId(faqPojo.getId());
            }
            faq.setId(faqPojo.getId());
            faq.setQuestion(faqPojo.getQuestion());
            faq.setAnswer(faqPojo.getAnswer());
            faqRepo.save(faq);
            return null;
        }



        @Override
        public User findByEmail(String email) {
            User user = userRepo.findByEmail(email)
                    .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
            return user;
        }

        @Override
        public String save(BlogPojo blogPojo) {
            return null;
        }

        @Override
        public UserPojo findByPassword(String password) {
            return null;
        }

        @Override
        public List<Contact> fetchAllContact() {
            return this.contactRepo.findAll();
        }

        @Override
        public Contact CfetchById(Integer id) {
            return contactRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        }

        @Override
        public void CdeleteById(Integer id) {
            contactRepo.deleteById(id);
        }



        private void sendPassword(String email, String password ){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Your new password is:");
            message.setText(password);
            mailSender.send(message);
        }
        @Override
        public void processPasswordResetRequest(String email){
            Optional<User> optionalUser = userRepo.findByEmail(email);
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                String password = generatePassword();
                sendPassword(email, password);
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodePassword = passwordEncoder.encode(password);
                user.setPassword(encodePassword);
                userRepo.save(user);
            }
        }
        @Override
        public void sendEmail() {
            try {
                Map<String, String> model = new HashMap<>();

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

                Template template = emailConfig.getTemplate("emailTemp.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

                mimeMessageHelper.setTo("sendfrom@yopmail.com");
                mimeMessageHelper.setText(html, true);
                mimeMessageHelper.setSubject("Registration");
                mimeMessageHelper.setFrom("sendTo@yopma+il.com");

                taskExecutor.execute(new Thread() {
                    public void run() {
                        mailSender.send(message);
                    }
                });
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        @Override
        public String updateResetPassword(String email) {
            User user = (User) userRepo.findByEmail(email)
                    .orElseThrow(()-> new RuntimeException("Invalid User email"));
            String updated_password = generatePassword();
            try {
                userRepo.updatePassword(updated_password, email);
                return "CHANGED";
            } catch (Exception e){
                e.printStackTrace();
            }
            return "ds";
        }

        public String generatePassword() {
            int length = 8;
            String password = "";
            Random r = new Random();
            for (int i = 0; i < length; i++) {
                int randomChar = (int)(r.nextInt(94) + 33);
                char c = (char)randomChar;
                password += c;
            }
            return password;

        }
    }









