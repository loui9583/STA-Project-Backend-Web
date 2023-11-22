package dat3.Course.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.Course.entity.Course;
import dat3.airplane.entity.Airplane;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponse {
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private LocalDate courseDate;
    private String courseLocation;
    private Airplane airplane; //change to airplane object when implemented
    private String courseType;
    private String simulatorType;
    private double coursePrice;
    private boolean isEASAApproved;
    private boolean isATPLUnfreezingPossible;

    public CourseResponse(Course course){
        this.id = course.getId();
        this.courseDate = course.getCourseDate();
        this.courseLocation = course.getCourseLocation();
        this.airplane = course.getAirplane();
        this.courseType = course.getCourseType();
        this.simulatorType = course.getSimulatorType();
        this.coursePrice = course.getCoursePrice();
        this.isEASAApproved = course.isEASAApproved();
        this.isATPLUnfreezingPossible = course.isATPLUnfreezingPossible();

    }
}
