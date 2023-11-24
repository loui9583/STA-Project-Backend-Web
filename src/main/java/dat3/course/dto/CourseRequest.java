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
    private String isEASAApproved;
    private String isATPLUnfreezingPossible;

    public static Course courseFromRequest(CourseRequest courseRequest) {
        return Course.builder()
                .courseDate(courseRequest.getCourseDate())
                .courseLocation(courseRequest.getCourseLocation())
                .airplane(Airplane.builder().id(courseRequest.getAirplaneId()).build())
                .courseType(courseRequest.getCourseType())
                .simulatorType(courseRequest.getSimulatorType())
                .coursePrice(courseRequest.getCoursePrice())
                .isEASAApproved(courseRequest.getIsEASAApproved())
                .isATPLUnfreezingPossible(courseRequest.getIsATPLUnfreezingPossible())
                .build();
    }
}
