package pl.fabianlewandowski.workout.model;

import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Exercise.class)
    @Size(min = 1, message = "Training must contains min. one exercise")
    private List<Exercise> exercises;

    @PrePersist
    private void trainingDate(){
        this.date = new Date();
    }
}
