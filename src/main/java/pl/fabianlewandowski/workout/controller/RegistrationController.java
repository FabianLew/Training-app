package pl.fabianlewandowski.workout.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.fabianlewandowski.workout.model.RegistrationForm;
import pl.fabianlewandowski.workout.model.User;
import pl.fabianlewandowski.workout.repository.UserRepo;


@Controller
@RequestMapping("/registration")
@Slf4j
public class RegistrationController {

    UserRepo userRepo;
    PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getRegistrationPage(Model model){
        model.addAttribute("registration",new User());
        return "registrationPage";
    }

    @PostMapping
    public String registerUser(RegistrationForm form){
        userRepo.save(form.toUser(passwordEncoder));
        log.info(form.toUser(passwordEncoder).toString());
        return "redirect:/login";
    }
}
