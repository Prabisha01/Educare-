
    package com.example.security.educare.Services.Impl;

    import com.example.security.educare.Entity.Contact;
    import com.example.security.educare.Entity.User;
    import com.example.security.educare.Pojo.ContactPojo;
    import com.example.security.educare.Repo.ContactRepo;
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
        public UserPojo findByUserName(String email) {
            User user = userRepo.findByUserName(email)
                    .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
            return new UserPojo(user);
        }

    }





