package pl.fabianlewandowski.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.fabianlewandowski.workout.model.Training;
import pl.fabianlewandowski.workout.repository.TrainingRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
public class TrainingRestController {
    TrainingRepo trainingRepo;

    @Autowired
    public TrainingRestController(TrainingRepo trainingRepo) {
        this.trainingRepo = trainingRepo;
    }

    @GetMapping
    public List<Training> getTrainings(){
        return trainingRepo.findAll();
    }

    @GetMapping("/{Id}")
    public Training getTrainingByID(@PathVariable Long Id){
        return trainingRepo.findTrainingById(Id);
    }
}
