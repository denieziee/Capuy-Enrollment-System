package org.example.Implementations;

import org.example.Interfaces.ICourseService;
import org.example.Entities.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements ICourseService {
    private List<Course> courseList = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
        System.out.println("Course added successfully: " + course.getCourseName());
    }

    @Override
    public void updateCourse(Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equalsIgnoreCase(updatedCourse.getCourseID())) {
                courseList.set(i, updatedCourse);
                System.out.println("Course [" + updatedCourse.getCourseID() + "] updated.");
                return;
            }
        }
        System.out.println("Error: Course ID " + updatedCourse.getCourseID() + " not found.");
    }

    @Override
    public void removeCourse(String courseId) {
        boolean removed = courseList.removeIf(c -> c.getCourseID().equalsIgnoreCase(courseId));
        if (removed) {
            System.out.println("Course [" + courseId + "] removed from system.");
        } else {
            System.out.println("Error: Course ID " + courseId + " not found.");
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseList);
    }

    @Override
    public Course getCourseById(String courseId) {
        return courseList.stream()
                .filter(c -> c.getCourseID().equalsIgnoreCase(courseId))
                .findFirst()
                .orElse(null);
    }
}