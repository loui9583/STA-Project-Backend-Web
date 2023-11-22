package dat3.Course.dto;

import dat3.Course.entity.Course;
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

    public static Course courseFromRequest(CourseRequest courseRequest){
    return Course.builder().courseDate(courseRequest.courseDate).courseLocation(courseRequest.courseLocation)
            .airplaneId(courseRequest.airplaneId).courseType(courseRequest.courseType).simulatorType(courseRequest.simulatorType)
            .coursePrice(courseRequest.coursePrice).isEASAApproved(courseRequest.isEASAApproved).isATPLUnfreezingPossible(courseRequest.isATPLUnfreezingPossible)
            .build();

    }

}
