 

//import model.*;
import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String DATA_DIR = "data/";
    
    // WRITE TO FILE - Writing students to CSV
    public static void writeStudentsToFile(List<Student> students) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "students.txt"))) {
            writer.println("# Student Records - Format: ID,Name,Surname,Email,Phone,RegDate,Role,StudentNumber,Major,Year,GPA,Standing,AdvisorID");
            for (Student s : students) {
                writer.println(s.toCSV());
            }
            System.out.println("✅ Saved " + students.size() + " students to file.");
        }
    }
    
    // READ FROM FILE - Reading students from CSV
    public static List<Student> readStudentsFromFile() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(DATA_DIR + "students.txt");
        
        if (!file.exists()) {
            System.out.println(" Student file not found. Starting with empty list.");
            return students;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (isFirstLine || line.trim().isEmpty() || line.startsWith("#")) {
                    isFirstLine = false;
                    continue;
                }
                
                String[] parts = line.split(",");
                if (parts.length >= 13) {
                    Student s = new Student(
                        parts[0], parts[1], parts[2], parts[3], parts[4],
                        parts[7], parts[8], Integer.parseInt(parts[9]), 
                        Double.parseDouble(parts[10]), parts[12]
                    );
                    students.add(s);
                }
            }
        }
        System.out.println(" Loaded " + students.size() + " students from file.");
        return students;
    }
    
    // Write lecturers to file
    public static void writeLecturersToFile(List<Lecturer> lecturers) throws IOException 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_DIR + "lecturers.txt")))
        {
            writer.println("# Lecturer Records");
            for (Lecturer l : lecturers) {
                writer.println(l.toCSV());
            }
            System.out.println(" Saved " + lecturers.size() + " lecturers to file.");
        }
    }
    
    // Read lecturers from file
    public static List<Lecturer> readLecturersFromFile() throws IOException
    
    {
        List<Lecturer> lecturers = new ArrayList<>();
        File file = new File(DATA_DIR + "lecturers.txt");
        
        if (!file.exists()) return lecturers;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length >= 12) 
                
                
                {
                    Lecturer l = new Lecturer(parts[0], parts[1], parts[2], parts[3], parts[4],
                            parts[7], parts[8], parts[9], parts[10], Double.parseDouble(parts[11]));
                    String[] courses = parts[12].split(";");
                    for (String course : courses) 
                    
                    {
                        if (!course.isEmpty()) l.addCourse(course);
                    }
                    lecturers.add(l);
                }
            }
        }
        return lecturers;
    }
}