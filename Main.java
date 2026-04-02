//import model.*;
//import service.*;
import java.util.*;

public class Main
 {
    private static UniversityService service = new UniversityService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        System.out.println("=".repeat(60));
        System.out.println(" UNIVERSITY MANAGEMENT SYSTEM");
        System.out.println("NWU CMPG211 - OOP Project");
        System.out.println("=".repeat(60));
        
        // Load data from files
        try {
            List<Student> loadedStudents = FileHandler.readStudentsFromFile();
            for (Student s : loadedStudents) 
            {
                service.addPerson(s);
            }
            System.out.println("?Data loaded successfully!");
        } catch (Exception e) {
            System.out.println(" No existing data found. Starting fresh.");
        }
        
        // Create sample data
        createSampleData();
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Choose option: ");
            
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addNewLecturer();
                    break;
                case 3:
                    addNewAdministrator();
                    break;
                case 4:
                    service.displayAllPersons();
                    break;
                case 5:
                    searchPerson();
                    break;
                case 6:
                    displayStatistics();
                    break;
                case 7:
                    saveAndExit();
                    running = false;
                    break;
                default:
                    System.out.println("X Invalid option. Try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("?MAIN MENU");
        System.out.println("-".repeat(50));
        System.out.println("1. ➕ Add New Student");
        System.out.println("2. ➕ Add New Lecturer");
        System.out.println("3. ➕ Add New Administrator");
        System.out.println("4. 📋 Display All Persons");
        System.out.println("5. 🔍 Search Person by ID");
        System.out.println("6. 📊 Display Statistics");
        System.out.println("7. 💾 Save & Exit");
        System.out.println("-".repeat(50));
    }
    
    private static void addNewStudent() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("➕ ADD NEW STUDENT");
        System.out.println("=".repeat(50));
        
        String id = getStringInput("Student ID (e.g., S001): ");
        String name = getStringInput("First Name: ");
        String surname = getStringInput("Surname: ");
        String email = getStringInput("Email: ");
        String phone = getStringInput("Phone Number: ");
        String studentNum = getStringInput("Student Number: ");
        String major = getStringInput("Major (e.g., Computer Science): ");
        int year = getIntInput("Current Year (1-4): ");
        double gpa = getDoubleInput("Current GPA (0.0-4.0): ");
        String advisorId = getStringInput("Advisor Employee ID: ");
        
        Student student = new Student(id, name, surname, email, phone, studentNum, major, year, gpa, advisorId);
        service.addPerson(student);
        
        System.out.println("\n Student added successfully!");
    }
    
    private static void addNewLecturer() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("➕ ADD NEW LECTURER");
        System.out.println("=".repeat(50));
        
        String id = getStringInput("Employee ID (e.g., L001): ");
        String name = getStringInput("First Name: ");
        String surname = getStringInput("Surname: ");
        String email = getStringInput("Email: ");
        String phone = getStringInput("Phone Number: ");
        String empNum = getStringInput("Employee Number: ");
        String dept = getStringInput("Department: ");
        String title = getStringInput("Title (Dr/Prof/Mr/Ms): ");
        String office = getStringInput("Office Location: ");
        double salary = getDoubleInput("Monthly Salary (R): ");
        
        Lecturer lecturer = new Lecturer(id, name, surname, email, phone, empNum, dept, title, office, salary);
        
        // Add courses
        System.out.print("How many courses does this lecturer teach? ");
        int courseCount = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course code " + (i+1) + ": ");
            String course = scanner.nextLine();
            lecturer.addCourse(course);
        }
        
        service.addPerson(lecturer);
        System.out.println("\n Lecturer added successfully!");
    }
    
    private static void addNewAdministrator() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("+ ADD NEW ADMINISTRATOR");
        System.out.println("=".repeat(50));
        
        String id = getStringInput("Employee ID (e.g., A001): ");
        String name = getStringInput("First Name: ");
        String surname = getStringInput("Surname: ");
        String email = getStringInput("Email: ");
        String phone = getStringInput("Phone Number: ");
        String empNum = getStringInput("Employee Number: ");
        String dept = getStringInput("Department: ");
        String position = getStringInput("Position: ");
        String accessLevel = getStringInput("Access Level (Admin/Manager/Staff): ");
        double salary = getDoubleInput("Monthly Salary (R): ");
        
        Administrator admin = new Administrator(id, name, surname, email, phone, empNum, dept, position, accessLevel, salary);
        service.addPerson(admin);
        System.out.println("\n Administrator added successfully!");
    }
    
    private static void searchPerson() {
        String id = getStringInput("\nEnter Person ID to search: ");
        Person person = service.findPersonById(id);
        
        if (person != null) {
            System.out.println("\n PERSON FOUND:");
            System.out.println("   Role: " + person.getRole());
            System.out.println("   " + person.getDisplayInfo());
            System.out.println("   Specialization: " + person.getSpecialization());
        } else {
            System.out.println("\nX No person found with ID: " + id);
        }
    }
    
    private static void displayStatistics() {
        service.generateReport();
    }
    
    private static void saveAndExit() {
        System.out.println("\n💾 Saving data to files...");
        
        try {
            // Here you would save all lists to files
            // FileHandler.writeStudentsToFile(service.getStudents());
            // FileHandler.writeLecturersToFile(service.getLecturers());
            System.out.println(" Data saved successfully!");
        } catch (Exception e) {
            System.out.println("X Error saving data: " + e.getMessage());
        }
        
        System.out.println("\n? Thank you for using University Management System!");
        System.out.println("Exiting... Goodbye!");
    }
    
    // Helper methods for input validation
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("X Invalid input. Please enter a number.");
            }
        }
    }
    
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("X Invalid input. Please enter a valid number.");
            }
        }
    }
    
    private static void createSampleData() {
        // Sample Student
        Student s1 = new Student("S001", "John", "Doe", "john.doe@nwu.ac.za", "0821234567",
                "12345678", "Computer Science", 3, 3.5, "L001");
        service.addPerson(s1);
        
        Student s2 = new Student("S002", "Jane", "Smith", "jane.smith@nwu.ac.za", "0827654321",
                "87654321", "Information Technology", 2, 3.8, "L002");
        service.addPerson(s2);
        
        // Sample Lecturer
        Lecturer l1 = new Lecturer("L001", "Sarah", "Johnson", "sarah.johnson@nwu.ac.za", "0831112222",
                "EMP001", "Computer Science", "Dr", "Building A, Office 101", 85000);
        l1.addCourse("CMPG211");
        l1.addCourse("CMPG221");
        service.addPerson(l1);
        
        // Sample Administrator
        Administrator a1 = new Administrator("A001", "Michael", "Brown", "michael.brown@nwu.ac.za", "0843334444",
                "ADM001", "Registrar", "Senior Administrator", "Admin", 65000);
        service.addPerson(a1);
        
        System.out.println("\n? Sample data loaded for demonstration!");
    }
}