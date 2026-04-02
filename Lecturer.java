 

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Person {
    // SPECIALIZATION - unique fields for Lecturer
    private String employeeNumber;
    private String department;
    private String title; // Dr, Prof, Mr, Ms
    private List<String> coursesTeaching;
    private String officeLocation;
    private double salary;
    
    // Constructor
    public Lecturer(String id, String name, String surname, String email, String phoneNumber,
                    String employeeNumber, String department, String title, String officeLocation, double salary) {
        super(id, name, surname, email, phoneNumber);
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.title = title;
        this.coursesTeaching = new ArrayList<>();
        this.officeLocation = officeLocation;
        this.salary = salary;
    }
    
    // Getters and Setters
    public String getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public List<String> getCoursesTeaching() { return coursesTeaching; }
    public void setCoursesTeaching(List<String> coursesTeaching) { this.coursesTeaching = coursesTeaching; }
    
    public String getOfficeLocation() { return officeLocation; }
    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    // Add course to teaching list
    public void addCourse(String courseCode) {
        if (!coursesTeaching.contains(courseCode)) {
            coursesTeaching.add(courseCode);
        }
    }
    
    public void removeCourse(String courseCode) {
        coursesTeaching.remove(courseCode);
    }
    
    @Override
    public String getRole() {
        return "LECTURER";
    }
    
    @Override
    public String getSpecialization() {
        return department;
    }
    
    // SPECIALIZATION - unique method
    public String getFullTitle() {
        return title + " " + super.getName() + " " + super.getSurname();
    }
    
    public int getCourseCount() {
        return coursesTeaching.size();
    }
    
    @Override
    public String getDisplayInfo() {
        String courses = String.join(", ", coursesTeaching);
        return super.getDisplayInfo() + String.format(" | Emp#: %s | Dept: %s | Title: %s | Courses: [%s] | Office: %s",
                employeeNumber, department, title, courses.isEmpty() ? "None" : courses, officeLocation);
    }
    
    @Override
    public String toCSV() {
        String coursesStr = String.join(";", coursesTeaching);
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%.2f",
                super.getId(), super.getName(), super.getSurname(), super.getEmail(),
                super.getPhoneNumber(), super.getFormattedDate(), getRole(),
                employeeNumber, department, title, coursesStr, salary);
    }
}