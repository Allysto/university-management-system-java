 

// INHERITANCE - extends Person
public class Student extends Person {
    // SPECIALIZATION - unique fields for Student
    private String studentNumber;
    private String major;
    private int currentYear;
    private double gpa;
    private String advisorId;
    
    // Constructor
    public Student(String id, String name, String surname, String email, String phoneNumber,
                   String studentNumber, String major, int currentYear, double gpa, String advisorId) {
        super(id, name, surname, email, phoneNumber);
        this.studentNumber = studentNumber;
        this.major = major;
        this.currentYear = currentYear;
        this.gpa = gpa;
        this.advisorId = advisorId;
    }
    
    // Getters and Setters
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    
    public int getCurrentYear() { return currentYear; }
    public void setCurrentYear(int currentYear) { this.currentYear = currentYear; }
    
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    
    public String getAdvisorId() { return advisorId; }
    public void setAdvisorId(String advisorId) { this.advisorId = advisorId; }
    
    // POLYMORPHISM - overriding abstract methods
    @Override
    public String getRole() {
        return "STUDENT";
    }
    
    @Override
    public String getSpecialization() {
        return major;
    }
    
    // SPECIALIZATION - unique method only for Student
    public String getAcademicStanding() {
        if (gpa >= 3.5) return "Excellent";
        else if (gpa >= 3.0) return "Good";
        else if (gpa >= 2.0) return "Satisfactory";
        else return "Academic Probation";
    }
    
    // POLYMORPHISM - overriding getDisplayInfo
    @Override
    public String getDisplayInfo() {
        return super.getDisplayInfo() + String.format(" | Student#: %s | Major: %s | Year: %d | GPA: %.2f | Standing: %s",
                studentNumber, major, currentYear, gpa, getAcademicStanding());
    }
    
    // POLYMORPHISM - overriding toCSV
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%.2f,%s",
                super.getId(), super.getName(), super.getSurname(), super.getEmail(), 
                super.getPhoneNumber(), super.getFormattedDate(), getRole(),
                studentNumber, major, currentYear, gpa, getAcademicStanding(), advisorId);
    }
}