import org.example.Entities.Course;
import org.example.Entities.Student;
import org.example.Exceptions.DuplicateIdException;
import org.example.Exceptions.InvalidIdFormatException;
import org.example.Implementations.StudentServiceImpl;
import org.example.Interfaces.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    @DisplayName("Should throw exception if ID is empty")
    void testEmptyIdThrowsException() {
        IStudentService service = new StudentServiceImpl();
        Student emptyStudent = new Student("", "No Name", "IT");

        assertThrows(InvalidIdFormatException.class, () -> {
            service.addStudent(emptyStudent);
        });
    }

    @Test
    @DisplayName("Should throw exception if ID is not numeric")
    void testNonNumericIdThrowsException() {
        IStudentService service = new StudentServiceImpl();
        Student badStudent = new Student("ABC", "John Doe", "BSIT");

        assertThrows(InvalidIdFormatException.class, () -> {
            service.addStudent(badStudent);
        });
    }

@Test
@DisplayName("Should successfully enroll student in a course")
void testEnrollStudentInCourse() throws DuplicateIdException, InvalidIdFormatException {
    IStudentService service = new StudentServiceImpl();
    Student s = new Student("101", "John Doe", "BSIT");
    Course c = new Course("5001", "Java Programming", "BSIT");

    service.addStudent(s);

    // ACT
    service.enrollStudentInCourse(s, c);

    // ASSERT
    assertEquals(1, s.getEnrolledCourses().size());
    assertEquals("Java Programming", s.getEnrolledCourses().get(0).getCourseName());
}

    @Test
    @DisplayName("Should not allow duplicate course enrollment for same student")
    void testDuplicateCourseEnrollment() throws DuplicateIdException, InvalidIdFormatException {
        IStudentService service = new StudentServiceImpl();
        Student s = new Student("102", "Jane Doe", "BSIT");
        Course c = new Course("5001", "Java Programming", "BSIT");

        service.addStudent(s);

        // ACT
        service.enrollStudentInCourse(s, c);
        service.enrollStudentInCourse(s, c); // Try adding again

        // ASSERT
        assertEquals(1, s.getEnrolledCourses().size(), "Should only contain the course once");
    }

    @Test
    void testAddAndRetrieveStudent() throws DuplicateIdException, InvalidIdFormatException {
        // ARRANGE
        IStudentService service = new StudentServiceImpl();
        Student s = new Student("101", "John Doe", "CS");

        // ACT
        service.addStudent(s);

        // ASSERT
        assertNotNull(service.getStudentById("101"));
        assertEquals("John Doe", service.getStudentById("101").getName());
    }

    @Test
    void testRemoveStudentDeletesFromList() throws DuplicateIdException, InvalidIdFormatException {
        IStudentService service = new StudentServiceImpl();
        service.addStudent(new Student("102", "Jane Doe", "CS"));

        // ACT
        service.removeStudent("102");

        // ASSERT
        assertNull(service.getStudentById("102"));
    }
}
