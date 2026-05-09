package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Entities.Student;
import org.example.Entities.Section;
import org.example.Entities.Department;
import org.example.Interfaces.IEnrollmentService;
import org.example.Exceptions.SectionFullException;

public class EnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {

        // 1. Check if the section is already at or over capacity
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException("Failed: Section [" +
                    section.getSectionName() + "] has reached its limit of " +
                    section.getMaxCapacity() + " students.");
        }
        // 2. Logic to prevent double enrollment
        if (section.getEnrolledStudents().contains(student)) {
            System.out.println(" Notice: Student " + student.getName() + " is already in this section.");
            return;
        }
        // 3. Add student if validation passes
        section.getEnrolledStudents().add(student);
        System.out.println("Success: " + student.getName() + " enrolled in " + section.getSectionName());
    }

    @Override
    public void enrollStudentInCourse(Student student, Course course) {
        // Check if the student already has this course in their list
        if (!student.getEnrolledCourses().contains(course)) {
            student.addCourse(course);
            System.out.println(student.getName() + " successfully registered for " + course.getCourseName());
        } else {
            System.out.println(student.getName() + " is already enrolled in " + course.getCourseName());
        }
    }

    @Override
    public void viewDepartmentHierarchy(Department dept) {
        System.out.println("\n--- " + dept.getDepartmentName().toUpperCase() + " HIERARCHY ---");

        if (dept.getSections().isEmpty()) {
            System.out.println("  (No sections created yet)");
            return;
        }

        for (Section section : dept.getSections()) {
            System.out.println("\nSection: " + section.getSectionName() +
                    " [" + section.getEnrolledStudents().size() + "/" + section.getMaxCapacity() + "]");

            String instructor = (section.getAssignedInstructor() != null)
                    ? section.getAssignedInstructor().getName()
                    : "No Instructor Assigned";
            System.out.println("   Instructor: " + instructor);

            System.out.println("   Enrolled Students:");
            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("     - None");
            } else {
                for (Student s : section.getEnrolledStudents()) {
                    System.out.println("     • [" + s.getID() + "] " + s.getName());
                }
            }
        }
    }
}