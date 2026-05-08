import org.example.Entities.Student;
import org.example.Implementations.StudentServiceImpl;
import org.example.Interfaces.IStudentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    void testAddAndRetrieveStudent() {
        // ARRANGE
        IStudentService service = new StudentServiceImpl();
        Student s = new Student("ID1", "John Doe", "CS");

        // ACT
        service.addStudent(s);

        // ASSERT
        assertNotNull(service.getStudentById("ID1"));
        assertEquals("John Doe", service.getStudentById("ID1").getName());
    }

    @Test
    void testRemoveStudentDeletesFromList() {
        IStudentService service = new StudentServiceImpl();
        service.addStudent(new Student("ID2", "Jane Doe", "CS"));

        // ACT
        service.removeStudent("ID2");

        // ASSERT
        assertNull(service.getStudentById("ID2"));
    }
}
