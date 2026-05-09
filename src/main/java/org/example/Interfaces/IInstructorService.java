package org.example.Interfaces;

import org.example.Entities.Instructor;
import org.example.Entities.Section;
import org.example.Exceptions.DuplicateIdException;

import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor) throws DuplicateIdException;;
    void assignInstructorToSection(Instructor instructor, Section section);
    Instructor getInstructorDetails(String instructorId);
    List<Instructor> getAllInstructors();
    void updateInstructor(Instructor instructor);
    void deleteInstructor(Instructor instructor);
}