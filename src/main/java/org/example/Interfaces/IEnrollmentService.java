package org.example.Interfaces;

import org.example.Entities.Course;
import org.example.Entities.Student;
import org.example.Entities.Section;
import org.example.Entities.Department;
import org.example.Exceptions.SectionFullException;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section) throws SectionFullException;
    void enrollStudentInCourse(Student student, Course course);
    void viewDepartmentHierarchy(Department dept);
}