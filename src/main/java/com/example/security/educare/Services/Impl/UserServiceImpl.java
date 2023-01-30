
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

    import lombok.RequiredArgsConstructor;

    import org.springframework.http.HttpStatus;

    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.List;


    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {
        public final ContactRepo contactRepo;
        public final UserRepo userRepo;
        public final FaqRepo faqRepo;




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


    }








