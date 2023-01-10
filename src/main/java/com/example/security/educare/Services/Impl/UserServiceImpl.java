
    package com.example.security.educare.Services.Impl;

    import com.example.security.educare.Entity.Contact;
    import com.example.security.educare.Repo.ContactRepo;
    import com.example.security.educare.Services.UserService;
    import com.example.security.educare.UserPojo.ContactPojo;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class UserServiceImpl implements UserService {
        public final ContactRepo contactRepo;



        @Override
        public String sendMsg(ContactPojo contactPojo) {
            Contact contact=new Contact();
            contact.setFullname(contactPojo.getFullname());
            contact.setEmail(contactPojo.getEmail());
            contact.setSubject(contactPojo.getSubject());
            contact.setMessage(contactPojo.getMessage());
            contactRepo.save(contact);
            return "submit";
        }
    }


