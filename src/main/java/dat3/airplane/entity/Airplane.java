package dat3.airplane.entity;


import dat3.course.entity.Course;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor

public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String airplaneType;
    private boolean isCurrentlyAvailable;

    @OneToMany(mappedBy = "airplane")
    List<Course> courses = new ArrayList<>();

    public Airplane(String airplaneType, boolean isCurrentlyAvailable) {
        this.airplaneType = airplaneType;
        this.isCurrentlyAvailable = isCurrentlyAvailable;
    }
}
