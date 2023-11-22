package dat3.Course.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.airplane.entity.Airplane;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    LocalDate courseDate;
    private String CourseInfo;
    private String courseLocation;
    @ManyToOne
    private Airplane airplane; //change to airplane object when implemented

    private int airplaneId;

    private String courseType;
    private String simulatorType;
    private double coursePrice;
    private boolean isEASAApproved;
    private boolean isATPLUnfreezingPossible;

}

