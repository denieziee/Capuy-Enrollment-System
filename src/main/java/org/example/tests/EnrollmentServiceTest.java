package org.example.tests;

import org.example.Entities.*;
import org.example.Implementations.*;
import org.example.Interfaces.*;
import org.example.Exceptions.SectionFullException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentServiceTest {

    @Test
    void testEnrollmentThrowsExceptionWhenSectionFull() throws SectionFullException {
        // ARRANGE
        IEnrollmentService service = new EnrollmentServiceImpl();
        Section smallSection = new Section("TEST-101", 1);
        Student s1 = new Student("001", "Alice", "IT");
        Student s2 = new Student("002", "Bob", "IT");

        service.enrollStudentInSection(s1, smallSection);

        assertThrows(SectionFullException.class, () -> {
            service.enrollStudentInSection(s2, smallSection);
        });
    }
}

