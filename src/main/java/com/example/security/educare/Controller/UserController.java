package com.example.security.educare.Controller;
import com.example.security.educare.Entity.Contact;
import com.example.security.educare.Entity.User;
import com.example.security.educare.Pojo.BlogPojo;
import com.example.security.educare.Pojo.ContactPojo;
import com.example.security.educare.Pojo.FaqPojo;
import com.example.security.educare.Services.UserService;

import com.example.security.educare.Pojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class  UserController {
    private final UserService userService;
    private final ValidationAutoConfiguration validationAutoConfiguration;





    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "signup";

    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.fetchById(id);
        model.addAttribute("user", new UserPojo(user));
        return "/user/create";
    }


    @GetMapping("/delete/{id}")
    public String deleteuser(@PathVariable("id") Integer id) {
        System.out.println("delete");
        userService.deleteById(id);
        return "redirect:/user/list";

    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userService.saveUser(userPojo);
        return "redirect:/user/list";

    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("user", new UserPojo());
            return "/login";
        }

        return "redirect:/user/home";



    }



    @GetMapping("/contact")
    public String getPage(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("prof", userService.findByEmail(principal.getName()));
        }
        model.addAttribute("contact", new ContactPojo());
        return "Contact";
    }

    @PostMapping("/send-message")
    public String submitMessage(@Valid ContactPojo contactPojo) {
        userService.submitMsg(contactPojo);
        return "redirect:/user/Contact";
    }

    @PostMapping("/logout")
    public String logout(Authentication authentication) {
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.clearContext();
        }
        return "/login";
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable("id") Integer id, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        User user = userService.fetchById(id);

        model.addAttribute("user", new UserPojo(user));
        model.addAttribute("prof", user);

        return "update";
    }


    @GetMapping("/about")
    public String getAbout() {
        return "companyProfile";
    }

    @GetMapping("/course")
    public String getCourse() {
        return "Course";
    }



    @GetMapping("/homepage")
    public String gethomepage(Model model, Principal principal, Authentication authentication ) {
        if (authentication!=null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (grantedAuthority.getAuthority().equals("Admin")) {
                    return "redirect:/admin/dashboard";
                }
            }
        }
        if (principal != null) {
            model.addAttribute("prof", userService.findByEmail(principal.getName()));
        }
        return "homepage";
    }

    @GetMapping("/python")
    public String getPython() {
        return "Python";
    }
    @GetMapping("/java")
    public String getJava() {
        return "Java";
    }

    @GetMapping("/userguide")
    public String getGuide() {
        return "userguide";
    }

    @GetMapping("/dart")
    public String getDart() {
        return "Dart";

    }


    @GetMapping("/quiz")
    public String getquiz() {
        return "Quiz";

    }
    @GetMapping("/certificate")
    public String getcerticate() {
        return "certificate";

    }
    @GetMapping("/forgotpassword")
    public String forgotpassword(Model model) {
        model.addAttribute("user", new UserPojo());
        return ("forgotpassword");
    }

    @PostMapping("/changepassword")
    public String changepassword(@RequestParam("email") String email, Model model, @Valid UserPojo userPojo) {
        userService.processPasswordResetRequest(userPojo.getEmail());
        model.addAttribute("message", "Your new password has been sent to your email Please " +
                "check your inbox");
        return "redirect:/user/login";
    }
}











