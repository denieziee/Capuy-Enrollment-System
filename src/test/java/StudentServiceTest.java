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

        assertThrows(IllegalArgumentException.class, () -> {
            service.addStudent(badStudent);
        });
    }

    @Test
    void testAddAndRetrieveStudent() throws DuplicateIdException {
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
    void testRemoveStudentDeletesFromList() throws DuplicateIdException {
        IStudentService service = new StudentServiceImpl();
        service.addStudent(new Student("102", "Jane Doe", "CS"));

        // ACT
        service.removeStudent("102");

        // ASSERT
        assertNull(service.getStudentById("102"));
    }
}
