package dat3.course.dto;

import dat3.course.entity.Course;
import dat3.airplane.entity.Airplane;
import dat3.course.entity.Course;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {
    private LocalDate courseDate;
    private String courseLocation;
    private int airplaneId;
    private String courseType;
    private String simulatorType;
    private double coursePrice;
    private boolean isEASAApproved;
    private boolean isATPLUnfreezingPossible;

    public static Course courseFromRequest(CourseRequest courseRequest, Airplane airplane) {
        return Course.builder()
                .courseDate(courseRequest.getCourseDate())
                .courseLocation(courseRequest.getCourseLocation())
                .airplane(airplane) // Set the Airplane object directly
                .courseType(courseRequest.getCourseType())
                .simulatorType(courseRequest.getSimulatorType())
                .coursePrice(courseRequest.getCoursePrice())
                .isEASAApproved(courseRequest.isEASAApproved())
                .isATPLUnfreezingPossible(courseRequest.isATPLUnfreezingPossible())
                .build();
    }


}
