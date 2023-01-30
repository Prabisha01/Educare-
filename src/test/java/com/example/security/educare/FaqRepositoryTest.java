package com.example.security.educare;

import com.example.security.educare.Entity.Faq;
import com.example.security.educare.Repo.FaqRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


    @DataJpaTest
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class FaqRepositoryTest {

        @Autowired
        private FaqRepo faqRepo;


        @Test
        @Order(1)
        public void saveFaqTest() {


            Faq faq = Faq.builder()
                    .answer("Hello")
                    .question("Hi")
                    .build();

            faqRepo.save(faq);

            Assertions.assertThat(faq.getId()).isGreaterThan(0);
        }

        @Test
        @Order(2)
        public void getFaqTest() {

            Faq faq = Faq.builder()
                    .answer("Hello")
                    .question("Hi")
                    .build();

            faqRepo.save(faq);


            Faq faqCreated = faqRepo.findById(faq.getId()).get();
            Assertions.assertThat(faq.getId()).isEqualTo(faqCreated.getId());

        }

        @Test
        @Order(3)
        public void getListOfFaqTest() {
            Faq faq = Faq.builder()
                    .answer("Hello")
                    .question("Hi")
                    .build();

            faqRepo.save(faq);
            List<Faq> User = faqRepo.findAll();
            Assertions.assertThat(User.size()).isGreaterThan(0);
        }


        @Test
        @Order(4)
        public void updateFaqTest() {

            Faq faq = Faq.builder()
                    .answer("No")
                    .build();

            faqRepo.save(faq);

            Faq faq1 = faqRepo.findById(faq.getId()).get();

            faq1.setAnswer("Yes");

            Faq faqUpdated = faqRepo.save(faq);

            Assertions.assertThat(faqUpdated.getAnswer()).isEqualTo("No");

        }

    }
//        @Test
//        @Order(5)
//        public void deleteFaqTest(){
//
//            Faq faq2 = Faq.builder()
//                    .question("hi")
//                    .answer("asd")
//                    .build();
//
//            faqRepo.save(faq2);
//
//
//            Faq faq = faqRepo.findById(faq2.getId()).get();
//            faqRepo.delete(faq);
//
//            Faq faq3= null;
//            Optional<Faq> optionalFeedback = faqRepo.findfaqByAnswer("asd");
//            if(optionalFeedback.isPresent()){
//                faq3 = optionalFeedback.get();
//            }
//
//            Assertions.assertThat(faq3).isNull();
//
//        }
//
//
//    }
