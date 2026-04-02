 

public class Administrator extends Person {
    // SPECIALIZATION - unique fields
    private String employeeNumber;
    private String department;
    private String position;
    private String accessLevel; // Admin, Manager, Staff
    private double salary;
    
    public Administrator(String id, String name, String surname, String email, String phoneNumber,
                        String employeeNumber, String department, String position, String accessLevel, double salary) {
        super(id, name, surname, email, phoneNumber);
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.position = position;
        this.accessLevel = accessLevel;
        this.salary = salary;
    }
    
    // Getters and Setters
    public String getEmployeeNumber() { return employeeNumber; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
    public String getAccessLevel() { return accessLevel; }
    public double getSalary() { return salary; }
    
    @Override
    public String getRole() {
        return "ADMINISTRATOR";
    }
    
    @Override
    public String getSpecialization() {
        return department + " - " + position;
    }
    
    // SPECIALIZATION - unique method
    public boolean hasAdminAccess() {
        return accessLevel.equalsIgnoreCase("Admin");
    }
    
    @Override
    public String getDisplayInfo() {
        return super.getDisplayInfo() + String.format(" | Emp#: %s | Dept: %s | Position: %s | Access: %s",
                employeeNumber, department, position, accessLevel);
    }
    
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%.2f",
                super.getId(), super.getName(), super.getSurname(), super.getEmail(),
                super.getPhoneNumber(), super.getFormattedDate(), getRole(),
                employeeNumber, department, position, salary);
    }
}