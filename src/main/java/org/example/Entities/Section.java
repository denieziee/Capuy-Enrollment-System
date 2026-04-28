package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private List<Student> enrolledStudents;
    private Instructor assignedInstructor;

    public Section() {
        this("IT2C", 30);
    }

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public List<Student> getEnrolledStudents() { return enrolledStudents; }

    public Instructor getAssignedInstructor() { return assignedInstructor; }
    public void setAssignedInstructor(Instructor assignedInstructor) { this.assignedInstructor = assignedInstructor; }

    @Override
    public String toString() {
        String instructorName = (assignedInstructor != null) ? assignedInstructor.getName() : "None Assigned";
        return "\n" +
                "  ┌──────── SECTION OVERVIEW ────────┐\n" +
                "    Section  : " + sectionName + "\n" +
                "    Instructor: " + instructorName + "\n" +
                "    Capacity : " + enrolledStudents.size() + "/" + maxCapacity + "\n" +
                "  └──────────────────────────────────┘";
    }
}