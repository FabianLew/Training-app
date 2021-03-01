package pl.fabianlewandowski.workout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
public class Exercise {

    @Id
    private final String id;
    private final String name;
    private final MusclePart muscle_part;


    public static enum MusclePart{
        CHEST, SHOULDERS, BACK, LEGS, ARMS
    }


}
