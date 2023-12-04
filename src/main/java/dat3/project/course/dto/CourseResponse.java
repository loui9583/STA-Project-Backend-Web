package dat3.project.course.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.project.course.entity.Course;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponse {
    private int id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private String pageLink;
    private String venue;

    public CourseResponse(Course course){
        this.id = course.getId();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.startDate = course.getStartDate();
        this.pageLink = course.getPageLink();
        this.venue = course.getVenue();
    }
}
