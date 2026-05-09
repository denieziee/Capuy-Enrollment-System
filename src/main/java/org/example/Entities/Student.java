package org.example.Entities;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String program;
    private List<Course> enrolledCourses = new ArrayList<>();

    public void addCourse(Course course) {
        this.enrolledCourses.add(course);
    } public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Student(){
        super();
    }

    public Student(String studentID){
        super(studentID);
    }

    public Student(String studentID, String studentName){
        super(studentID, studentName);
    }

    public Student(String studentID, String studentName, String program){
        super(studentID, studentName);
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    @Override
    public String toString() {
        String courseNames = enrolledCourses.isEmpty() ? "None" :
                enrolledCourses.stream()
                        .map(Course::getCourseName)
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("None");
        return "\n" +
                "  [ STUDENT PROFILE ]\n" +
                "  ID      : " + super.getID() + "\n" +
                "  Name    : " + super.getName() + "\n" +
                "  Program : " + program + "\n" +
                "  Courses : " + courseNames + "\n" +
                "  ───────────────────────────";
    }
}