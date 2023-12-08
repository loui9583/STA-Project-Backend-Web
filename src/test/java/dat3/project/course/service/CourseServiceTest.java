package dat3.project.course.service;

import dat3.project.course.dto.CourseRequest;
import dat3.project.course.dto.CourseResponse;
import dat3.project.course.entity.Course;
import dat3.project.course.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CourseServiceTest {
    CourseService courseService;
    @Autowired
    CourseRepository courseRepository;
    private Course course1;
    private Course course2;

    @BeforeEach
    void setUp() {
    course1 = Course.builder().title("A title").build();
    course2 = Course.builder().title("Another title").build();
    courseRepository.saveAndFlush(course1);
    courseRepository.saveAndFlush(course2);
    courseService = new CourseService(courseRepository);
    }

    @Test
    void addCourse() {
        CourseRequest newCourse = CourseRequest.builder().title("First course").build();
        CourseResponse addedCourse = courseService.addCourse(newCourse);

        assertEquals(newCourse.getTitle(), addedCourse.getTitle());

    }

    @Test
    void deleteCourse() {
        courseService.deleteCourse((long) course1.getId());
        assertFalse(courseRepository.existsById(course1.getId()));
    }

    @Test
    void getAllCourses() {
        List<CourseResponse> courseResponses = courseService.getAllCourses();

        assertEquals(2, courseResponses.size());
    }

    @Test
    void getCourseById() {
        CourseResponse courseResponse = courseService.getCourseById((long) course1.getId());

        assertEquals(courseResponse.getId(), course1.getId());
    }

    @Test
    void editCourse() {
        CourseRequest newCourse = CourseRequest.builder().title("Title").build();
        CourseResponse editedCourse = courseService.editCourse(newCourse, (long) course1.getId());

        assertEquals(course1.getTitle(), editedCourse.getTitle());
    }
}