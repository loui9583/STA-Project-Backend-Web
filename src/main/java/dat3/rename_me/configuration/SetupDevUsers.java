package dat3.rename_me.configuration;

import dat3.airplane.entity.Airplane;
import dat3.airplane.repository.AirplaneRepository;
import dat3.course.dto.CourseRequest;
import dat3.course.repository.CourseRepository;
import dat3.course.service.CourseService;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

import java.time.LocalDate;

@Controller
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    PasswordEncoder passwordEncoder;
    String passwordUsedByAll;

    AirplaneRepository airplaneRepository;

    CourseRepository courseRepository;

    CourseService courseService;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, PasswordEncoder passwordEncoder,
                         AirplaneRepository airplaneRepository, CourseService courseService) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.passwordEncoder = passwordEncoder;
        passwordUsedByAll = "test12";
        this.airplaneRepository=airplaneRepository;
        this.courseService=courseService;
    }



    @Override
    public void run(ApplicationArguments args) {
        setupUserWithRoleUsers();
        setUpAirplanes();
        setUpCourses();
    }

     /*****************************************************************************************
     IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO

     If you see the lines below in log-outputs on Azure, forget whatever had your attention on, AND FIX THIS PROBLEM

     *****************************************************************************************/
    private void setupUserWithRoleUsers() {
        System.out.println("******************************************************************************");
        System.out.println("********** IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ************");
        System.out.println();
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println();
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }

    private void setUpAirplanes(){
        //Oprettelse af fly
        Airplane airplane1 = new Airplane("B737", true);
        Airplane airplane2 = new Airplane("B787", true);
        Airplane airplane3 = new Airplane("B777", true);
        Airplane airplane4 = new Airplane("A320", true);
        airplaneRepository.save(airplane1);
        airplaneRepository.save(airplane2);
        airplaneRepository.save(airplane3);
        airplaneRepository.save(airplane4);
    }

    private void setUpCourses(){
        //Oprettelse af kursus
        LocalDate date1 = LocalDate.parse("2024-12-24");
        LocalDate date2 = LocalDate.parse("2025-08-11");
        LocalDate date3 = LocalDate.parse("2025-04-22");
        LocalDate date4 = LocalDate.parse("2025-01-05");




        CourseRequest courseRequest1 = new CourseRequest(date1, "Copenhagen", 1,
                "TypeRating", "Full Motion Simulator",
                20.000, true, true);

        CourseRequest courseRequest2 = new CourseRequest(date2, "Madrid", 2,
                "TypeRating", "Full Motion Simulator",
                20.000, true, true);

        CourseRequest courseRequest3 = new CourseRequest(date3, "Heathrow", 3,
                "TypeRating", "Full Motion Simulator",
                20.000, true, true);

        CourseRequest courseRequest4 = new CourseRequest(date4, "London", 4,
                "TypeRating", "Full Motion Simulator",
                20.000, true, true);

        courseService.addCourse(courseRequest1);
        courseService.addCourse(courseRequest2);
        courseService.addCourse(courseRequest3);
        courseService.addCourse(courseRequest4);
    }
}
