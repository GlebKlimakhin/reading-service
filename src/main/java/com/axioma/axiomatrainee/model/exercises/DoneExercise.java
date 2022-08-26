package com.axioma.axiomatrainee.model.exercises;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "done_exercises")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoneExercise {

    @EmbeddedId
    DoneExerciseId doneExerciseId;

    @Column(name = "score")
    @Digits(integer = 1, fraction = 0)
    @NotNull
    Integer score;

    @Enumerated
    @Column(name = "type")
    @NotBlank
    ExerciseType exerciseType;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "done_at")
    Date doneAt;

}
