package dat3.Course.api;

import dat3.Course.dto.CourseRequest;
import dat3.Course.dto.CourseResponse;
import dat3.Course.service.CourseService;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        CourseResponse deletedCourse = courseService.deleteCourse(id);
        if (deletedCourse != null) {
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found or unable to delete");
        }
    }
}
