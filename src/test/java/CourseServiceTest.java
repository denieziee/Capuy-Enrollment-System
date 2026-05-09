import org.example.Entities.Course;
import org.example.Exceptions.InvalidIdFormatException;
import org.example.Exceptions.DuplicateIdException;
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
    @DisplayName("Should throw InvalidIdFormatException for empty Course ID")
    void testEmptyCourseId() {
        Course emptyCourse = new Course("", "Blank", "BSIT");
        assertThrows(InvalidIdFormatException.class, () -> {
            courseService.addCourse(emptyCourse);
        });
    }

    @Test
    @DisplayName("Should throw exception if Course ID is not numeric")
    void testNonNumericCourseId() {
        Course badCourse = new Course("JAVA-101", "Intro", "BSIT");
        assertThrows(IllegalArgumentException.class, () -> {
            courseService.addCourse(badCourse);
        });
    }

    @Test
    @DisplayName("Should add and list all courses")
    void testAddAndGetAllCourses() throws DuplicateIdException, InvalidIdFormatException {
        Course c1 = new Course("5001", "Intro to Java", "BSIT");
        Course c2 = new Course("5002", "Data Structures", "BSIT");

        courseService.addCourse(c1);
        courseService.addCourse(c2);

        List<Course> allCourses = courseService.getAllCourses();
        assertEquals(2, courseService.getAllCourses().size());
    }

    @Test
    @DisplayName("Should successfully update course details")
    void testUpdateCourse() throws DuplicateIdException, InvalidIdFormatException {
        Course original = new Course("5001", "Old Name", "BSIT");
        courseService.addCourse(original);

        Course updated = new Course("5001", "New Name", "BSCS");
        courseService.updateCourse(updated);

        // ACT: Finding the course in the list
        Course result = courseService.getAllCourses().stream()
                .filter(c -> c.getCourseID().equals("C1"))
                .findFirst()
                .orElse(null);

        // ASSERT
        assertNotNull(result);
        assertEquals("New Name", result.getCourseName()); // Changed to getCourseName()
        assertEquals("BSCS", result.getProgram());
    }
}