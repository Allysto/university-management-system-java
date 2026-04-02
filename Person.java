 

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Abstract class demonstrating ABSTRACTION
public abstract class Person implements Serializable {
    // ENCAPSULATION - private fields
    private String id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private LocalDateTime registrationDate;
    
    // Constructor
    public Person(String id, String name, String surname, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationDate = LocalDateTime.now();
    }
    
    // Getters and Setters (ENCAPSULATION)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public LocalDateTime getRegistrationDate() { return registrationDate; }
    
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return registrationDate.format(formatter);
    }
    
    // ABSTRACT METHOD - forces subclasses to implement (POLYMORPHISM)
    public abstract String getRole();
    
    // Method to be overridden by subclasses
    public abstract String getSpecialization();
    
    // Common method for all persons (will be overridden)
    public String getDisplayInfo() {
        return String.format("ID: %s | Name: %s %s | Email: %s | Phone: %s | Registered: %s",
                id, name, surname, email, phoneNumber, getFormattedDate());
    }
    
    // Method to convert to CSV format for file writing
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                id, name, surname, email, phoneNumber, getFormattedDate(), getRole());
    }
    
    @Override
    public String toString() {
        return getDisplayInfo();
    }
}