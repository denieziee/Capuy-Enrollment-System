# Capstone Project Brief: Interface-Driven Enrollment System
- A Java-based
- designed to handle student registration, course enrollment, instructor assignments, and tuition fee management.

## 🍙 Features
* **Student & Instructor Management:** Full CRUD operations for student and faculty records.
* **Department Hierarchy:** Organizes the college into sections with specific capacities.
* **Enrollment:** * Enroll students into specific sections (handles `SectionFullException`).
* Register students for multiple courses.
* **Tuition System:** * Calculates fees based on a **fixed rate (₱1500.00)** per course.
* Validates payments using `InvalidPaymentAmountException` to prevent overpayment or negative entries.
* **Robust Error Handling:** Custom exceptions for duplicate IDs, invalid formats, and business logic violations.

---
## 📂 Project Structure

```text
src/
├──main/
  ├──java/
    ├── Entities/        # Data models (Student, Course, Section, etc.)
      ├──Couse
      ├──Department
      ├──Instructor
      ├──Person
      ├──Section
      ├──Student
      ├──TuitionFeePayment
    ├── Exceptions/      # Custom Exception classes
      ├──DuplicateIdException
      ├──InvalidIdFormatException
      ├──InvalidPaymentAmountException
      ├──SectionFullException
    ├── Implementations/ # Business logic logic
      ├──CourseServiceImpl
      ├──EnrollmentServiceImpl
      ├──InstructorServiceImpl
      ├──StudentServiceImpl
      ├──TuitionServiceImpl
    ├── Interfaces/      # Service definitions
      ├──ICourseService
      ├──IEnrollmentService
      ├──IInstructorService
      ├──IStudentService
      ├──ITuitionService
    └── ui/              # Main console interface
      ├──Main
  ├──test/
    ├──java/
      ├──CourseServiceTest/
      ├──EnrollmentServiceTest/
      ├──InstructorServiceTest/
      ├──StudentServiceTest/
      ├──TuitionServiceTest/
├──README.md
```
---

## ⚖️ Business Rules (Tuition)

* **Rate:** ₱1,500.00 per course.
* **Payment Validation:** * Payments must be greater than 0.
* Payments cannot exceed the current remaining balance.
