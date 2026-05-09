package org.example.Interfaces;

import org.example.Entities.Course;
import org.example.Exceptions.DuplicateIdException;

import java.util.List;

public interface ICourseService {
    void addCourse(Course course) throws DuplicateIdException;
    void updateCourse(Course course);
    void removeCourse(String courseId);
    List<Course> getAllCourses();
    Course getCourseById(String courseId);
}