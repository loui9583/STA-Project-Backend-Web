package dat3.project.course.service;

import dat3.project.course.dto.CourseRequest;
import dat3.project.course.dto.CourseResponse;

import dat3.project.course.entity.Course;
import dat3.project.course.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse addCourse(CourseRequest courseRequest){
        Course course = CourseRequest.getEntity(courseRequest);
        course = courseRepository.save(course);
        return new CourseResponse(course);
    }
    public CourseResponse deleteCourse(Long id){
        Course course = courseRepository.findById(Math.toIntExact(id)).orElseThrow();
        courseRepository.delete(course);
        return new CourseResponse(course);
    }
    public CourseResponse editCourse(CourseRequest courseRequest, Long id) {
        Course course = courseRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        course.setStartDate(courseRequest.getStartDate());
        course.setPageLink(courseRequest.getPageLink());
        course.setVenue(courseRequest.getVenue());

        courseRepository.save(course);

        return new CourseResponse(course);
    }
    public List<CourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(CourseResponse::new)
                .collect(Collectors.toList());
    }
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
        return new CourseResponse(course);
    }
}

