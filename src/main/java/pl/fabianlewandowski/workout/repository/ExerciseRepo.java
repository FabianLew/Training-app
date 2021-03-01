package pl.fabianlewandowski.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fabianlewandowski.workout.model.Exercise;

public interface ExerciseRepo extends JpaRepository<Exercise,String> {
}
