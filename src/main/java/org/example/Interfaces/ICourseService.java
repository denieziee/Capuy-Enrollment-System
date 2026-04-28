package org.example.Interfaces;

import org.example.Entities.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(Course course);
    void removeCourse(String courseId);
    List<Course> getAllCourses();
    Course getCourseById(String courseId);
}