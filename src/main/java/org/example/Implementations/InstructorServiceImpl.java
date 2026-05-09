package org.example.Implementations;

import org.example.Exceptions.DuplicateIdException;
import org.example.Interfaces.IInstructorService;
import org.example.Entities.Instructor;
import org.example.Entities.Section;
import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) throws DuplicateIdException {
        for (Instructor i : instructorList) {
            if (i.getID().equalsIgnoreCase(instructor.getID())) {
                throw new DuplicateIdException("ID is already exists!");
            }
        }
        instructorList.add(instructor);
        System.out.println("\nInstructor added successfully!");
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        boolean found = false;
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getID().equalsIgnoreCase(instructor.getID())) {
                instructorList.set(i, instructor);
                found = true;
                break;
            }
        } if (found) {
            System.out.println("Instructor record updated.");
        } else {
            System.out.println("Cannot update. Instructor does not exist.");
        }
        }

    @Override
    public void removeInstructor(String instructorId) {
        boolean removed = instructorList.removeIf(i -> i.getID().equalsIgnoreCase(instructorId));
        if (removed) {
            System.out.println("Instructor removed successfully.");
        } else {
            System.out.println("Error: Instructor not found.");
        }
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