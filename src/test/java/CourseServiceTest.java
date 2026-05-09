import org.example.Entities.Course;
import org.example.Implementations.CourseServiceImpl;
import org.example.Interfaces.ICourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {
    private ICourseService courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl();
    }

    @Test
    @DisplayName("Should add and list all courses")
    void testAddAndGetAllCourses() {
        Course c1 = new Course("CS101", "Intro to Java", "BSIT");
        Course c2 = new Course("CS102", "Data Structures", "BSIT");

        courseService.addCourse(c1);
        courseService.addCourse(c2);

        List<Course> allCourses = courseService.getAllCourses();
        assertEquals(2, allCourses.size());
    }

    @Test
    @DisplayName("Should successfully update course details")
    void testUpdateCourse() {
        Course original = new Course("C1", "Old Name", "BSIT");
        courseService.addCourse(original);

        Course updated = new Course("C1", "New Name", "BSCS");
        courseService.updateCourse(updated);

        // ACT: Finding the course in the list
        Course result = courseService.getAllCourses().stream()
                .filter(c -> c.getCourseID().equals("C1")) // Changed to getCourseID()
                .findFirst()
                .orElse(null);

        // ASSERT
        assertNotNull(result);
        assertEquals("New Name", result.getCourseName()); // Changed to getCourseName()
        assertEquals("BSCS", result.getProgram());
    }
}