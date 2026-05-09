import org.example.Entities.Instructor;
import org.example.Entities.Section;
import org.example.Exceptions.DuplicateIdException;
import org.example.Implementations.InstructorServiceImpl;
import org.example.Interfaces.IInstructorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstructorServiceTest {
    private IInstructorService instructorService;

    @BeforeEach
    void setUp() {
        instructorService = new InstructorServiceImpl();
    }

    @Test
    @DisplayName("Should throw exception if Instructor ID is not numeric")
    void testNonNumericInstructorId() {
        Instructor badProf = new Instructor("PROF-ABC", "Dr. Smith");
        assertThrows(IllegalArgumentException.class, () -> {
            instructorService.addInstructor(badProf);
        });
    }

    @Test
    @DisplayName("Should successfully add and retrieve an instructor")
    void testAddInstructor() throws DuplicateIdException {
        Instructor prof = new Instructor("2001", "Dr. Smith", "Computer Science");
        instructorService.addInstructor(prof);

        Instructor retrieved = instructorService.getInstructorDetails("2001");
        assertNotNull(retrieved);
        assertEquals("Dr. Smith", retrieved.getName());
    }

    @Test
    @DisplayName("Should throw DuplicateIdException when ID already exists")
    void testDuplicateInstructorId() throws DuplicateIdException {
        Instructor prof1 = new Instructor("2001", "Dr. Smith");
        Instructor prof2 = new Instructor("2001", "Prof. Jones");

        instructorService.addInstructor(prof1);

        assertThrows(DuplicateIdException.class, () -> {
            instructorService.addInstructor(prof2);
        });
    }

    @Test
    @DisplayName("Should correctly assign instructor to a section")
    void testAssignInstructorToSection() {
        Instructor prof = new Instructor("2001", "Dr. Smith");
        Section section = new Section("BSIT-2C", 2);

        instructorService.assignInstructorToSection(prof, section);

        assertNotNull(section.getAssignedInstructor());
        assertEquals("Dr. Smith", section.getAssignedInstructor().getName());
    }
}