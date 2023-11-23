package dat3.course.service;

import dat3.airplane.entity.Airplane;
import dat3.course.dto.CourseRequest;
import dat3.course.dto.CourseResponse;

import dat3.course.entity.Course;
import dat3.course.repository.CourseRepository;
import dat3.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse addCourse(CourseRequest courseRequest, Airplane airplane){
        Course course = CourseRequest.courseFromRequest(courseRequest, airplane);
        course = courseRepository.save(course);
        return  new CourseResponse(course);
    }

    public CourseResponse deleteCourse(Long id){
        Course course = courseRepository.findById(Math.toIntExact(id)).orElseThrow();
        courseRepository.delete(course);
        return new CourseResponse(course);
    }
}
