package org.example.Interfaces;

import org.example.Entities.Instructor;
import org.example.Entities.Section;
import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void assignInstructorToSection(Instructor instructor, Section section);
    Instructor getInstructorDetails(String instructorId);
    List<Instructor> getAllInstructors();
}