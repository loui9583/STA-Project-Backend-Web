package dat3.project.course.api;

import dat3.project.course.dto.CourseRequest;
import dat3.project.course.dto.CourseResponse;
import dat3.project.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/courses")
@RestController
public class CourseController {
    CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
    return courseService.addCourse(courseRequest);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        CourseResponse deletedCourse = courseService.deleteCourse(id);
        if (deletedCourse != null) {
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editCourse(@RequestBody CourseRequest courseRequest, @PathVariable Long id) {
        CourseResponse editedCourse = courseService.editCourse(courseRequest, id);
        if (editedCourse != null) {
            return new ResponseEntity<>("Course edited successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found or unable to edit", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping()
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
}
