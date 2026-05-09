package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Exceptions.DuplicateIdException;
import org.example.Exceptions.InvalidIdFormatException;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student) throws DuplicateIdException, InvalidIdFormatException;
    void updateStudent(Student student);
    void removeStudent(String studentId);
    List<Student> getAllStudents();
    Student getStudentById(String studentId);
}