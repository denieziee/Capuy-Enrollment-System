package org.example.Entities;

public class Student extends Person{
    private String program;

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
        return "\n" +
                "  [ STUDENT PROFILE ]\n" +
                "  ID      : " + super.getID() + "\n" +
                "  Name    : " + super.getName() + "\n" +
                "  Program : " + program + "\n" +
                "  ───────────────────────────";
    }
}