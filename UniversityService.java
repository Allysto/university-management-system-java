 

//import model.*;
import java.util.*;

public class UniversityService {
    private List<Student> students;
    private List<Lecturer> lecturers;
    private List<Administrator> administrators;
    
    public UniversityService() {
        students = new ArrayList<>();
        lecturers = new ArrayList<>();
        administrators = new ArrayList<>();
    }
    
    // POLYMORPHISM - Method overloading for adding persons
    public void addPerson(Student student) {
        students.add(student);
        System.out.println(" Student added: " + student.getName() + " " + student.getSurname());
    }
    
    public void addPerson(Lecturer lecturer) {
        lecturers.add(lecturer);
        System.out.println(" Lecturer added: " + lecturer.getName() + " " + lecturer.getSurname());
    }
    
    public void addPerson(Administrator admin) {
        administrators.add(admin);
        System.out.println(" Administrator added: " + admin.getName() + " " + admin.getSurname());
    }
    
    // POLYMORPHISM - Displaying all persons
    public void displayAllPersons() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("? UNIVERSITY DIRECTORY");
        System.out.println("=".repeat(80));
        
        System.out.println("\n? STUDENTS (" + students.size() + "):");
        for (Student s : students) {
            System.out.println("   " + s.getDisplayInfo());
        }
        
        System.out.println("\n? LECTURERS (" + lecturers.size() + "):");
        for (Lecturer l : lecturers) {
            System.out.println("   " + l.getDisplayInfo());
        }
        
        System.out.println("\n? ADMINISTRATORS (" + administrators.size() + "):");
        for (Administrator a : administrators) {
            System.out.println("   " + a.getDisplayInfo());
        }
    }
    
    // Search by ID (demonstrates polymorphism in return type)
    public Person findPersonById(String id)
    
    {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        for (Lecturer l : lecturers) {
            if (l.getId().equals(id)) return l;
        }
        for (Administrator a : administrators) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }
    
    // SPECIALIZATION - Student-specific operations
    public List<Student> getStudentsByMajor(String major)
    
    {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                result.add(s);
            }
        }
        return result;
    }
    
    public List<Student> getStudentsOnProbation()
    
    {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getGpa() < 2.0) {
                result.add(s);
            }
        }
        return result;
    }
    
    // SPECIALIZATION - Lecturer-specific operations
    public List<Lecturer> getLecturersByDepartment(String department) 
    
    {
        List<Lecturer> result = new ArrayList<>();
        for (Lecturer l : lecturers) {
            if (l.getDepartment().equalsIgnoreCase(department)) 
            
            {
                result.add(l);
            }
        }
        return result;
    }
    
    // Analytics methods
    public double getAverageStudentGPA()
    
    {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student s : students) {
            total += s.getGpa();
        }
        return total / students.size();
    }
    
    public double getTotalMonthlySalaryExpense()
    
    {
        double total = 0;
        for (Lecturer l : lecturers) {
            total += l.getSalary();
        }
        for (Administrator a : administrators) {
            total += a.getSalary();
        }
        return total;
    }
    
    public void generateReport() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("? UNIVERSITY STATISTICS REPORT");
        System.out.println("=".repeat(80));
        System.out.printf("? Total Students: %d%n", students.size());
        System.out.printf("? Total Lecturers: %d%n", lecturers.size());
        System.out.printf("? Total Administrators: %d%n", administrators.size());
        System.out.printf("? Total Personnel: %d%n", students.size() + lecturers.size() + administrators.size());
        System.out.printf("? Average Student GPA: %.2f%n", getAverageStudentGPA());
        System.out.printf("?Monthly Salary Expense: R%.2f%n", getTotalMonthlySalaryExpense());
        
        int probationCount = getStudentsOnProbation().size();
        if (probationCount > 0)
        {
            System.out.printf(" Students on Academic Probation: %d%n", probationCount);
        }
    }
}