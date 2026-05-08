package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Exceptions.DuplicateIdException;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student) throws DuplicateIdException;
    void updateStudent(Student student);
    void removeStudent(String studentId);
    List<Student> getAllStudents();
    Student getStudentById(String studentId);
}