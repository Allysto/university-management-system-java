# 🏫 University Management System

[![Java](https://img.shields.io/badge/Java-11%2B-blue)](https://java.com)
[![OOP](https://img.shields.io/badge/OOP-Inheritance%20%7C%20Polymorphism-green)](https://github.com)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

A comprehensive **Java OOP project** demonstrating Inheritance, Polymorphism, Specialization, Encapsulation, Abstraction, and File I/O.

## 📚 OOP Concepts Demonstrated

| Concept | Implementation |
|---------|----------------|
| **Inheritance** | Student, Lecturer, Administrator extend Person |
| **Polymorphism** | Method overriding (getRole, getDisplayInfo, toCSV) |
| **Specialization** | Unique methods (getAcademicStanding, addCourse) |
| **Encapsulation** | Private fields with public getters/setters |
| **Abstraction** | Person abstract class with abstract methods |
| **File I/O** | CSV file reading/writing for data persistence |

## 🚀 Features

- 👨‍🎓 Student Management - Add, view, search students with GPA tracking
- 👨‍🏫 Lecturer Management - Manage lecturers with course assignments
- 👔 Admin Management - Track administrators with access levels
- 🔍 Search - Find any person by unique ID
- 📊 Analytics - Generate statistics (average GPA, salary expenses)
- 💾 File Persistence - Automatic save/load to CSV files

## 📁 Project Structure

```
universityManagementSystem/
├── Person.java (abstract)
├── Student.java
├── Lecturer.java
├── Administrator.java
├── UniversityService.java
├── FileHandler.java
├── Main.java
├── data/ (CSV files stored here)
└── README.md
```

## 🛠️ How to Run

### Prerequisites: Java JDK 11 or higher

```bash
javac *.java
java Main
```

## 📊 Sample Output

```
Total Students: 2
Average GPA: 3.65
Monthly Salary Expense: R150000.00
```

## 👨‍💻 Author

**Alfred Lebu** - BSc IT Graduate
- GitHub: [@Allysto](https://github.com/Allysto)
- Email: allylebo@gmail.com

## 📄 License

MIT License - Free for educational use
