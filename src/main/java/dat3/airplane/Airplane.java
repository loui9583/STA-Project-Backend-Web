package dat3.airplane;


import dat3.Course.entity.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

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
