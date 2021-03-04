package pl.fabianlewandowski.workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.fabianlewandowski.workout.model.User;
import pl.fabianlewandowski.workout.repository.UserRepo;

@Service
public class UserRepoUserDetailService implements UserDetailsService {

    UserRepo userRepo;

    @Autowired
    public UserRepoUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByUsername(username);
        if(user != null){
            return user;
        }
        else
            throw new UsernameNotFoundException(
                    "User" + username + "not found");
    }
}
