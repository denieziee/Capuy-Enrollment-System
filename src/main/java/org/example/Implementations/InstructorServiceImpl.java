package org.example.Implementations;

import org.example.Interfaces.IInstructorService;
import org.example.Entities.Instructor;
import org.example.Entities.Section;
import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
        System.out.println("Instructor added: " + instructor.getName());
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        if (instructor != null && section != null) {
            section.setAssignedInstructor(instructor);
            System.out.println("Assigned Instructor " + instructor.getName() + " to Section " + section.getSectionName());
        } else {
            System.out.println("Error: Assignment failed. Instructor or Section is null.");
        }
    }

    @Override
    public Instructor getInstructorDetails(String instructorId) {
        for (Instructor instructor : instructorList) {
            if (instructor.getID().equalsIgnoreCase(instructorId)) {
                return instructor;
            }
        }
        return null;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return new ArrayList<>(instructorList);
    }
}