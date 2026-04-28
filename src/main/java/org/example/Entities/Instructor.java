package org.example.Entities;

public class Instructor extends Person{
    private String course;

    public Instructor(){
        super();
    }

    public Instructor(String instructorID){
        super(instructorID);
    }

    public Instructor(String instructorID, String instructorName){
        super(instructorID, instructorName);
    }

    public Instructor(String instructorID, String instructorName, String course){
        super(instructorID, instructorName);
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    @Override
    public String toString() {
        return "\n" +
                "  ┌─────── INSTRUCTOR PROFILE ──────┐\n" +
                "    ID      : " + super.getID() + "\n" +
                "    Name    : " + super.getName() + "\n" +
                "    Specialty: " + course + "\n" +
                "  └─────────────────────────────────┘";
    }
}