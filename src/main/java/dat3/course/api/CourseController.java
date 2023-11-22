package dat3.course.api;

import dat3.course.dto.CourseRequest;
import dat3.course.dto.CourseResponse;
import dat3.course.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/courses")
@RestController
public class CourseController {
    CourseService courseService;

    @PostMapping
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
    return courseService.addCourse(courseRequest);
    }
}
