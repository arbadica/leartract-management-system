package ui;

import entity.*;
import exception.EntityNotFoundException;
import service.*;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            int choice = readIntInput("Select Option: ");

            switch (choice) {
                case 1 -> handleStudentMenu();
                case 2 -> handleCourseMenu();
                case 3 -> handleEnrollmentMenu();
                case 0 -> {
                    System.out.println("Exiting LearnTrack System. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please enter a valid menu option.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n===== LearnTrack Console UI =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
    }

    private static void handleStudentMenu() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");
        
        int choice = readIntInput("Choice: ");
        try {
            switch (choice) {
                case 1 -> {
                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("Email (Leave blank to skip): ");
                    String email = scanner.nextLine();
                    System.out.print("Batch: ");
                    String batch = scanner.nextLine();

                    int id = IdGenerator.getNextStudentId();
                    Student s = email.isBlank() ? 
                        new Student(id, fn, ln, batch) : 
                        new Student(id, fn, ln, email, batch);

                    studentService.addStudent(s);
                    System.out.println("Student created successfully! ID: " + id);
                }
                case 2 -> {
                    ArrayList<Student> list = studentService.getAllStudents();
                    if (list.isEmpty()) System.out.println("No students registered.");
                    else list.forEach(s -> System.out.println(s.getDisplayName()));
                }
                case 3 -> {
                    int id = readIntInput("Enter Student ID: ");
                    Student s = studentService.getStudentById(id);
                    System.out.println(s.getDisplayName());
                }
                case 4 -> {
                    int id = readIntInput("Enter Student ID to deactivate: ");
                    studentService.deactivateStudent(id);
                    System.out.println("Student status updated to inactive.");
                }
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleCourseMenu() {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Toggle Course Active Status");

        int choice = readIntInput("Choice: ");
        try {
            switch (choice) {
                case 1 -> {
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    int duration = readIntInput("Duration in Weeks: ");

                    int id = IdGenerator.getNextCourseId();
                    Course c = new Course(id, name, desc, duration);
                    courseService.addCourse(c);
                    System.out.println("Course added! ID: " + id);
                }
                case 2 -> {
                    ArrayList<Course> list = courseService.getAllCourses();
                    if (list.isEmpty()) System.out.println("No courses available.");
                    else list.forEach(System.out.println);
                }
                case 3 -> {
                    int id = readIntInput("Enter Course ID: ");
                    int status = readIntInput("Enter status (1 for Active, 0 for Inactive): ");
                    courseService.setCourseStatus(id, status == 1);
                    System.out.println("Course status updated.");
                }
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleEnrollmentMenu() {
        System.out.println("\n--- Enrollment Management ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Student Enrollments");
        System.out.println("3. Update Enrollment Status");

        int choice = readIntInput("Choice: ");
        try {
            switch (choice) {
                case 1 -> {
                    int sId = readIntInput("Enter Student ID: ");
                    studentService.getStudentById(sId); // verifies existence

                    int cId = readIntInput("Enter Course ID: ");
                    courseService.getCourseById(cId); // verifies existence

                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    Enrollment e = enrollmentService.enrollStudent(sId, cId, date);
                    System.out.println("Enrolled successfully! " + e);
                }
                case 2 -> {
                    int sId = readIntInput("Enter Student ID: ");
                    ArrayList<Enrollment> list = enrollmentService.getEnrollmentsByStudentId(sId);
                    if (list.isEmpty()) System.out.println("No enrollments found for this student.");
                    else list.forEach(System.out.println);
                }
                case 3 -> {
                    int eId = readIntInput("Enter Enrollment ID: ");
                    System.out.print("Enter Status (COMPLETED / CANCELLED / ACTIVE): ");
                    String status = scanner.nextLine().toUpperCase();
                    enrollmentService.updateStatus(eId, status);
                    System.out.println("Enrollment status updated successfully.");
                }
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int readIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}
