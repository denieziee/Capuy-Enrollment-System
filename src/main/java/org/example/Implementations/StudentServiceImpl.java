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
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList); // Return a copy for safety
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(student.getID())) {
                studentList.set(i, student);
                return;
            }
        }
    }

    @Override
    public void removeStudent(String studentId) {
        studentList.removeIf(s -> s.getID().equals(studentId));
    }
}