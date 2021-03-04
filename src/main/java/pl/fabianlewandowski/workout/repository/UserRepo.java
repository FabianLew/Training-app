package pl.fabianlewandowski.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fabianlewandowski.workout.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
