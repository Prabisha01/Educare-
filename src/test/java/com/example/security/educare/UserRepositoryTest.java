package com.example.security.educare;


import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Repo.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    public void saveUserTest() {
        User user = User.builder()
                .userName("tulasi")
                .password("1234")
                .build();
        userRepo.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);

    }
    @Test
    @Order(2)
    public void getUserTest(){
        User user=User.builder()
                .userName("salini")
                .password("1234")
                .build();
        userRepo.save(user);
        User userCreated = userRepo.findById(user.getId()).get();
        Assertions.assertThat(user.getId()).isEqualTo(userCreated.getId());
    }
}
