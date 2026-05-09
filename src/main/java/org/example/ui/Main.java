package org.example.ui;

import org.example.Entities.*;
import org.example.Exceptions.DuplicateIdException;
import org.example.Implementations.*;
import org.example.Interfaces.*;
import org.example.Exceptions.SectionFullException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Services
        IStudentService studentRegistration = new StudentServiceImpl();
        IInstructorService instructorRegistration = new InstructorServiceImpl();
        ICourseService courseRegistration = new CourseServiceImpl();
        ITuitionService feePayment = new TuitionServiceImpl();
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

        // Hierarchy Setup
        Department citeDept = new Department("College of Information Technology and Engineering");
        Section bsitIT2C = new Section("BSIT-IT2C", 2);
        citeDept.getSections().add(bsitIT2C);

        while (true) {
            try {
                System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                System.out.print("\n⋆⭒˚.⋆⋆⭒˚.⋆⋆⭒˚ MENU ⋆⭒˚.⋆⋆⭒˚.⋆⋆⭒\n" +
                        "\n" +
                        "1. Student Registration\n" +
                        "2. Instructor Registration\n" +
                        "3. Course Registration\n" +
                        "4. Enrollment & Hierarchy\n" +
                        "5. Tuition Fee Payment\n" +
                        "6. Exit\n" +
                        "★ Answer ★ : ");

                int input1 = scan.nextInt();
                scan.nextLine();

                if (input1 == 1) {
                    System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                    System.out.print("\n⋆⭒˚.⋆ Student Registration ⋆⭒˚.⋆\n" +
                            "\n" +
                            "1. Save Student\n" +
                            "2. Display Student\n" +
                            "3. Update Student\n" +
                            "4. Remove Student\n" +
                            "5. Back\n" +
                            "★ Answer ★ : ");
                    int InputStudentReg = scan.nextInt();
                    scan.nextLine();
                    switch (InputStudentReg) {
                        case 1:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nSave Student.\n");
                            System.out.print("Enter Student ID: ");
                            String studID = scan.nextLine();
                            System.out.print("Enter Student Name: ");
                            String studName = scan.nextLine();
                            System.out.print("Enter Program: ");
                            String studProgram = scan.nextLine();
                            studentRegistration.addStudent(new Student(studID, studName, studProgram));
                            break;
                        case 2:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nDisplay Student.\n");
                            studentRegistration.getAllStudents().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nUpdate Student.\n");
                            studentRegistration.getAllStudents().forEach(System.out::println);

                            System.out.print("\nEnter Student ID to Update: ");
                            String updateID = scan.nextLine();

                            Student existingStudent = studentRegistration.getStudentById(updateID);
                            if (existingStudent != null) {
                                System.out.print("Enter New Name: ");
                                String newName = scan.nextLine();
                                System.out.print("Enter New Program: ");
                                String newProg = scan.nextLine();
                                studentRegistration.updateStudent(new Student(updateID, newName, newProg));
                            } else {
                                System.out.println("Error: Student ID [" + updateID + "] not found.");
                            }
                            break;
                        case 4:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("Remove Student.\n");
                            studentRegistration.getAllStudents().forEach(System.out::println);
                            System.out.print("\nEnter Student ID to Remove: ");
                            String delStudID = scan.nextLine();
                            studentRegistration.removeStudent(delStudID);
                            break;
                        case 5:
                            System.out.println("\nShalom!");
                            break;
                        default:
                            System.out.println("Error.");
                            break;
                    }

                } else if (input1 == 2) {
                    System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                    System.out.print("\n⋆⭒˚.⋆ Instructor Registration ⋆⭒˚.⋆\n" +
                            "\n" +
                            "1. Save Instructor\n" +
                            "2. Display Instructor\n" +
                            "3. Update Instructor\n" +
                            "4. Remove Instructor\n" +
                            "5. Assign Instructor to Section\n" +
                            "6. Back\n" +
                            "★ Answer ★ : ");
                    int InputInstReg = scan.nextInt();
                    scan.nextLine();
                    switch (InputInstReg) {
                        case 1:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nSave Instructor.\n");
                            System.out.print("Enter Instructor ID: ");
                            String instID = scan.nextLine();
                            System.out.print("Enter Instructor Name: ");
                            String instName = scan.nextLine();
                            System.out.print("Enter Specialty Course: ");
                            String instCourse = scan.nextLine();
                            instructorRegistration.addInstructor(new Instructor(instID, instName, instCourse));
                            break;
                        case 2:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nDisplay Instructors.\n");
                            instructorRegistration.getAllInstructors().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nUpdate Instructor.\n");
                            instructorRegistration.getAllInstructors().forEach(System.out::println);
                            System.out.print("\nEnter Instructor ID to Update: ");
                            String upID = scan.nextLine();

                            Instructor existingInst = instructorRegistration.getInstructorDetails(upID);
                            if (existingInst != null) {
                                System.out.print("Enter New Name: ");
                                String newName = scan.nextLine();
                                System.out.print("Enter New Specialty: ");
                                String newSpec = scan.nextLine();
                                instructorRegistration.updateInstructor(new Instructor(upID, newName, newSpec));
                            } else {
                                System.out.println("Error: Instructor ID [" + upID + "] not found.");
                            }
                            break;
                        case 4:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nRemove Instructor.\n");
                            instructorRegistration.getAllInstructors().forEach(System.out::println);
                            System.out.print("\nEnter Instructor ID to Remove: ");
                            String remID = scan.nextLine();
                            instructorRegistration.removeInstructor(remID);
                            break;
                        case 5:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────\n");
                            System.out.println("\nAssign Instructor to Section\n");
                            instructorRegistration.getAllInstructors().forEach(System.out::println);
                            System.out.print("\nEnter Instructor ID to Assign: ");
                            String targetID = scan.nextLine();
                            Instructor targetInst = instructorRegistration.getInstructorDetails(targetID);
                            if (targetInst != null) {
                                instructorRegistration.assignInstructorToSection(targetInst, bsitIT2C);
                            } else {
                                System.out.println("Instructor not found.");
                            }
                            break;
                        case 6:
                            System.out.println("\nShalom!");
                            break;
                        default:
                            System.out.println("Error.");
                            break;
                    }

                } else if (input1 == 3) {
                    System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                    System.out.print("\nCourse Registration:\n" +
                            "\n" +
                            "1. Save Course\n" +
                            "2. Display Course\n" +
                            "3. Update Course\n" +
                            "4. Remove Course\n" +
                            "5. Back\n" +
                            "Answer: ");
                    int InputCourseReg = scan.nextInt();
                    scan.nextLine();
                    switch (InputCourseReg) {
                        case 1:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nSave Course.\n");
                            System.out.print("Enter Course ID: ");
                            String courseID = scan.nextLine();
                            System.out.print("Enter Course Name: ");
                            String courseName = scan.nextLine();
                            System.out.print("Enter Program: ");
                            String courseProgram = scan.nextLine();
                            courseRegistration.addCourse(new Course(courseID, courseName, courseProgram));
                            break;
                        case 2:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("\nDisplay Course.\n");
                            courseRegistration.getAllCourses().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("Update Course.\n");
                            courseRegistration.getAllCourses().forEach(System.out::println);
                            System.out.print("\nEnter Course ID to Update: ");
                            String updateCourseID = scan.nextLine();
                            System.out.print("Enter New Name: ");
                            String updateName = scan.nextLine();
                            System.out.print("Enter New Program: ");
                            String updateProg = scan.nextLine();
                            courseRegistration.updateCourse(new Course(updateCourseID, updateName, updateProg));
                            break;
                        case 4:
                            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                            System.out.println("Remove Course.\n");
                            courseRegistration.getAllCourses().forEach(System.out::println);
                            System.out.print("\nEnter Course ID to Remove: ");
                            String delCourseID = scan.nextLine();
                            courseRegistration.removeCourse(delCourseID);
                            break;
                        case 5:
                            System.out.println("\nShalom!");
                            break;
                        default:
                            System.out.println("Error.");
                            break;
                    }

                } else if (input1 == 4) {
                    System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                    System.out.print("\nEnrollment & Hierarchy:\n" +
                            "1. Enroll Student in BSIT-IT2C\n" +
                            "2. View Department Hierarchy\n" +
                            "Answer: ");
                    int InputEnroll = scan.nextInt();
                    scan.nextLine();
                    if (InputEnroll == 1) {
                        System.out.println("Available Students:\n");
                        studentRegistration.getAllStudents().forEach(System.out::println);
                        System.out.print("\nEnter Student ID: ");
                        String sid = scan.nextLine();
                        Student s = studentRegistration.getStudentById(sid);
                        if (s != null) {
                            try {
                                enrollmentService.enrollStudentInSection(s, bsitIT2C);
                            } catch (SectionFullException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else if (InputEnroll == 2) {
                        enrollmentService.viewDepartmentHierarchy(citeDept);
                    }

                } else if (input1 == 5) {
                    System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                    System.out.print("\n⋆⭒˚.⋆ Tuition Fee Payment ⋆⭒˚.⋆\n");
                    System.out.print("\nList of Students.");
                    System.out.print("\n_______________________________");
                    studentRegistration.getAllStudents().forEach(System.out::println);
                    System.out.print("\n_______________________________");
                    System.out.print("\nEnter Student ID for Payment: ");
                    String sid = scan.nextLine();
                    Student s = studentRegistration.getStudentById(sid);

                    if (s != null) {
                        double total = feePayment.calculateTotalFee(courseRegistration.getAllCourses());
                        TuitionFeePayment record = new TuitionFeePayment(total);
                        System.out.println("Total Fee: " + total);
                        System.out.print("Enter Payment Amount: ");
                        double amt = scan.nextDouble();
                        feePayment.makePayment(record, amt);
                        feePayment.displayPaymentStatus(record);
                    } else {
                        System.out.println("Student not found.");
                    }

                } else if (input1 == 6) {
                    System.out.println("\nExiting System...");
                    break;

                } else {
                    System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                    System.out.println("\nError: Invalid Selection.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter a number, try again.");
                scan.nextLine();
            } catch (DuplicateIdException e) {
                System.out.println("\nRegistration Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nSomething went wrong: " + e.getLocalizedMessage());
            }
        }
    }
}