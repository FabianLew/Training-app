package pl.fabianlewandowski.workout.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.fabianlewandowski.workout.model.Exercise;
import pl.fabianlewandowski.workout.model.Training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pl.fabianlewandowski.workout.model.Exercise.MusclePart;
import pl.fabianlewandowski.workout.model.User;
import pl.fabianlewandowski.workout.repository.ExerciseRepo;
import pl.fabianlewandowski.workout.repository.TrainingRepo;

import javax.validation.Valid;

@Controller
@RequestMapping("/training")
@Slf4j
public class TrainingController {


    private final TrainingRepo trainingRepo;
    private final ExerciseRepo exerciseRepo;

    @Autowired
    public TrainingController(TrainingRepo trainingRepo, ExerciseRepo exerciseRepo) {
        this.trainingRepo = trainingRepo;
        this.exerciseRepo = exerciseRepo;
    }

    @GetMapping
    public String getTraining(Model model){
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseRepo.findAll().forEach(i -> exerciseList.add(i));

        // TODO : make it using stream API
        List<Exercise> chestEx = filterByType(exerciseList,MusclePart.CHEST);
        List<Exercise> shouldersEx = filterByType(exerciseList,MusclePart.SHOULDERS);
        List<Exercise> backEx = filterByType(exerciseList,MusclePart.BACK);
        List<Exercise> legsEx = filterByType(exerciseList,MusclePart.LEGS);
        List<Exercise> armsEx = filterByType(exerciseList,MusclePart.ARMS);

        model.addAttribute("chestEx",chestEx);
        model.addAttribute("shouldersEx",shouldersEx);
        model.addAttribute("backEx",backEx);
        model.addAttribute("legsEx",legsEx);
        model.addAttribute("armsEx",armsEx);

        model.addAttribute("training" , new Training());
        return "training";
    }

    @PostMapping
    public String saveTraining(@Valid Training training, @AuthenticationPrincipal User user){
        training.setUser(user);
        trainingRepo.save(training);
        log.info(training.toString());
        return "redirect:/success";
    }

    private List<Exercise> filterByType(List<Exercise> exerciseList, MusclePart musclePart){
        List<Exercise> list = new ArrayList<>();
        for (Exercise ex: exerciseList){
            if(ex.getMuscle_part().equals(musclePart)){
                list.add(ex);
            }
        }
        return list;
    }
}
