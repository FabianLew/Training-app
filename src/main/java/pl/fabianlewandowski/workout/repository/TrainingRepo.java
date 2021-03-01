package pl.fabianlewandowski.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fabianlewandowski.workout.model.Training;

public interface TrainingRepo extends JpaRepository<Training,Long> {
}
