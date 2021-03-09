package pl.fabianlewandowski.workout.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.awt.*;
import java.util.Date;

@Data
public class RegistrationForm {
    private final String username;
    private final String password;
    private final String full_name;
    private final String age;
    private final String mail;
    private final String city;
    private final String street;
    private final String post_code;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username,
                passwordEncoder.encode(password),
                full_name,
                age,
                mail,
                city,
                street,
                post_code
        );
    }
}
