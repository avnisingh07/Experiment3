package assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.showMenu();
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchByPRN();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private void addStudent() {
        System.out.println("\nAdding a Student:");
        System.out.print("Enter PRN: ");
        String prn = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (DOB): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = new Student(prn, name, dob, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private void displayAllStudents() {
        System.out.println("\nList of Students:");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println("PRN: " + student.getPrn() + ", Name: " + student.getName() +
                    ", DOB: " + student.getDob() + ", Marks: " + student.getMarks());
        }
    }

    private void searchByPRN() {
        System.out.print("\nEnter PRN to search: ");
        String prn = scanner.nextLine();
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                System.out.println("Student found:");
                System.out.println("PRN: " + student.getPrn() + ", Name: " + student.getName() +
                        ", DOB: " + student.getDob() + ", Marks: " + student.getMarks());
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    private void searchByName() {
        System.out.print("\nEnter Name to search: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found:");
                System.out.println("PRN: " + student.getPrn() + ", Name: " + student.getName() +
                        ", DOB: " + student.getDob() + ", Marks: " + student.getMarks());
                return;
            }
        }
        System.out.println("Student with Name " + name + " not found.");
    }

    private void updateStudent() {
        System.out.print("\nEnter PRN of the student to update: ");
        String prn = scanner.nextLine();
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                System.out.println("Student found:");
                System.out.println("PRN: " + student.getPrn() + ", Name: " + student.getName() +
                        ", DOB: " + student.getDob() + ", Marks: " + student.getMarks());
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new Date of Birth (DOB): ");
                String newDob = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                double newMarks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                student.setName(newName);
                student.setDob(newDob);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    private void deleteStudent() {
        System.out.print("\nEnter PRN of the student to delete: ");
        String prn = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPrn().equalsIgnoreCase(prn)) {
                students.remove(i);
                System.out.println("Student with PRN " + prn + " deleted successfully!");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }
}

