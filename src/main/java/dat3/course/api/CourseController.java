package dat3.course.api;

import dat3.course.dto.CourseRequest;
import dat3.course.dto.CourseResponse;
import dat3.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/courses")
@RestController
public class CourseController {
    CourseService courseService;

    @PostMapping
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
    return courseService.addCourse(courseRequest);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        CourseResponse deletedCourse = courseService.deleteCourse(id);
        if (deletedCourse != null) {
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
}
