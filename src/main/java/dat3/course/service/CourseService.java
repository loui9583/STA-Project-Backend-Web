package dat3.course.service;

import dat3.airplane.entity.Airplane;
import dat3.course.dto.CourseRequest;
import dat3.course.dto.CourseResponse;

import dat3.course.entity.Course;
import dat3.course.repository.CourseRepository;
import dat3.course.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseService {
    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse addCourse(CourseRequest courseRequest){
        Course course = CourseRequest.courseFromRequest(courseRequest);
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

        course.setCourseDate(courseRequest.getCourseDate());
        course.setCourseLocation(courseRequest.getCourseLocation());
        course.setAirplane(Airplane.builder().id(courseRequest.getAirplaneId()).build());
        course.setCourseType(courseRequest.getCourseType());
        course.setSimulatorType(courseRequest.getSimulatorType());
        course.setCoursePrice(courseRequest.getCoursePrice());
        course.setEASAApproved(courseRequest.isEASAApproved());
        course.setATPLUnfreezingPossible(courseRequest.isATPLUnfreezingPossible());

        courseRepository.save(course);

        return new CourseResponse(course);
    }
}

