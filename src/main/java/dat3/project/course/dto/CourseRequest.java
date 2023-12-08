package dat3.project.course.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.project.course.entity.Course;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {

    private String title;
    private String description;
    private LocalDateTime startDate;
    private String pageLink;
    private String venue;
     public static Course getEntity(CourseRequest courseRequest){
        Course course = new Course();
        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        course.setStartDate(courseRequest.getStartDate());
        course.setPageLink(courseRequest.getPageLink());
        course.setVenue(courseRequest.getVenue());
        return course;
    }


}
