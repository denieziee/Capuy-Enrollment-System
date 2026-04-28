package org.example;

import org.example.Entities.*;
import org.example.Implementations.*;
import org.example.Interfaces.*;
import org.example.Exceptions.SectionFullException;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Services
        IStudentService studentRegistration = new StudentServiceImpl();
        ICourseService courseRegistration = new CourseServiceImpl();
        ITuitionService feePayment = new TuitionServiceImpl();
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

        // Hierarchy Setup
        Department ccsDept = new Department("College of Information Technology and Engineering");
        Section bsitIT2C = new Section("BSIT-IT2C", 2);
        ccsDept.getSections().add(bsitIT2C);

        while (true) {
            System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
            System.out.print("\n⋆⭒˚.⋆⋆⭒˚.⋆⋆⭒˚ MENU ⋆⭒˚.⋆⋆⭒˚.⋆⋆⭒\n" +
                    "1. Student Registration\n" +
                    "2. Course Registration\n" +
                    "3. Enrollment & Hierarchy\n" +
                    "4. Tuition Fee Payment\n" +
                    "5. Exit\n" +
                    "★ Answer ★ : ");

            int input1 = scan.nextInt();

            if (input1 == 1) {
                System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                System.out.print("\n⋆⭒˚.⋆ Student Registration ⋆⭒˚.⋆\n" +
                        "Pick a number.\n" +
                        "1. Save Student\n" +
                        "2. Display Student\n" +
                        "3. Update Student\n" +
                        "4. Remove Student\n" +
                        "★ Answer ★ : ");
                int InputStudentReg = scan.nextInt();
                scan.nextLine(); // Buffer clear
                switch (InputStudentReg) {
                    case 1:
                        System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                        System.out.println("\nSave Student.");
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
                        System.out.println("\nDisplay Student.");
                        studentRegistration.getAllStudents().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                        System.out.println("\nUpdate Student.");
                        System.out.print("Enter Student ID: ");
                        String newStudID = scan.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = scan.nextLine();
                        System.out.print("Enter New Program: ");
                        String newProg = scan.nextLine();
                        studentRegistration.updateStudent(new Student(newStudID, newName, newProg));
                        break;
                    case 4:
                        System.out.println("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                        System.out.println("Remove Student.");
                        System.out.print("Enter Student ID: ");
                        String delStudID = scan.nextLine();
                        studentRegistration.removeStudent(delStudID);
                        break;
                    default:
                        System.out.println("Error.");
                        break;
                }

            } else if (input1 == 2) {
                System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                System.out.print("\nCourse Registration:\n" +
                        "Pick a number.\n" +
                        "1. Save Course\n" +
                        "2. Display Course\n" +
                        "3. Update Course\n" +
                        "4. Remove Course\n" +
                        "Answer: ");
                int InputCourseReg = scan.nextInt();
                scan.nextLine(); // Buffer clear
                switch (InputCourseReg) {
                    case 1:
                        System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                        System.out.println("\nSave Course.");
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
                        System.out.println("\nDisplay Course.");
                        courseRegistration.getAllCourses().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                        System.out.println("Update Course.");
                        System.out.print("Enter Course ID: ");
                        String updateCourseID = scan.nextLine();
                        System.out.print("Enter New Name: ");
                        String updateName = scan.nextLine();
                        System.out.print("Enter New Program: ");
                        String updateProg = scan.nextLine();
                        courseRegistration.updateCourse(new Course(updateCourseID, updateName, updateProg));
                        break;
                    case 4:
                        System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                        System.out.println("Remove Course.");
                        System.out.print("Enter Course ID: ");
                        String delCourseID = scan.nextLine();
                        courseRegistration.removeCourse(delCourseID);
                        break;
                    default:
                        System.out.println("Error.");
                        break;
                }

            } else if (input1 == 3) {
                System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                System.out.print("\nEnrollment & Hierarchy:\n" +
                        "1. Enroll Student in BSIT-IT2C\n" +
                        "2. View Department Hierarchy\n" +
                        "Answer: ");
                int InputEnroll = scan.nextInt();
                scan.nextLine();
                if (InputEnroll == 1) {
                    System.out.print("Enter Student ID: ");
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
                    enrollmentService.viewDepartmentHierarchy(ccsDept);
                }

            } else if (input1 == 4) {
                System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                System.out.print("\n⋆⭒˚.⋆ Tuition Fee Payment ⋆⭒˚.⋆\n");

                System.out.print("Enter Student ID: ");
                scan.nextLine();
                String sid = scan.nextLine();
                Student s = studentRegistration.getStudentById(sid);

                if (s != null) {
                    double total = feePayment.calculateTotalFee(courseRegistration.getAllCourses());
                    TuitionFeePayment record = new TuitionFeePayment(total);
                    System.out.println(record);
                    System.out.print("Enter Payment Amount: ");
                    double amt = scan.nextDouble();
                    feePayment.makePayment(record, amt);
                    feePayment.displayPaymentStatus(record);
                } else {
                    System.out.println("Student not found.");
                }

            } else if (input1 == 5) {
                System.out.println("Exiting System...");
                System.exit(0);

            } else {
                System.out.print("\n─────────────୨ৎ୨ৎ୨ৎ─────────────");
                System.out.println("Error: Invalid Selection.\n");
            }
        }
    }
}