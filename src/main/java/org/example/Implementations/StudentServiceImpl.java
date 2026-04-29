package org.example.Implementations;

import org.example.Interfaces.IStudentService;
import org.example.Entities.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("\nStudent added successfully!");
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }

    @Override
    public void updateStudent(Student student) {
        // 1. Validation Logic
        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(student.getID())) {
                // 2. Perform the Update
                studentList.set(i, student);
                found = true;
                break;
            }
        }

        // 3. Feedback Logic
        if (found) {
            System.out.println("Success: Student record updated.");
        } else {
            System.out.println("Error: Cannot update. Student ID [" + student.getID() + "] does not exist.");
        }
    }

    @Override
    public void removeStudent(String studentId) {
        boolean removed = studentList.removeIf(s -> s.getID().equals(studentId));
        if (removed) {
            System.out.println("Student ID [" + studentId + "] removed.");
        } else {
            System.out.println("Error: Student ID " + studentId + " not found.");
        }
    }

    @Override
    public Student getStudentById(String studentId) {
        for (Student s : studentList) {
            if (s.getID().equalsIgnoreCase(studentId)) {
                return s;
            }
        }
        return null;
    }
}