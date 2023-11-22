package dat3.Course.service;

import dat3.Course.dto.CourseRequest;
import dat3.Course.dto.CourseResponse;
import dat3.Course.entity.Course;
import dat3.Course.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse addCourse(CourseRequest courseRequest){
        Course course = CourseRequest.courseFromRequest(courseRequest);
        course = courseRepository.save(course);
        return  new CourseResponse(course);

    }
}
