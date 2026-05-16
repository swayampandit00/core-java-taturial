import java.util.ArrayList;
import java.util.List;

/**
 * Advanced OOP Example
 * Demonstrates:
 * - Encapsulation with private fields and getters/setters
 * - Constructors (default, parameterized, copy)
 * - Method overloading
 * - Static members
 * - Object composition
 * - toString() and equals() overriding
 * - Immutable objects
 * - Builder pattern
 */

// Student class with full encapsulation
class Student {
    // Private fields (encapsulation)
    private String name;
    private int age;
    private String studentId;
    private double gpa;
    private List<String> courses;
    
    // Static field (shared among all instances)
    private static int totalStudents = 0;
    private static final String UNIVERSITY_NAME = "Java University";
    
    // Default constructor
    public Student() {
        this("Unknown", 0, "N/A", 0.0);
    }
    
    // Parameterized constructor
    public Student(String name, int age, String studentId, double gpa) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
        this.courses = new ArrayList<>();
        totalStudents++;
    }
    
    // Copy constructor
    public Student(Student other) {
        this(other.name, other.age, other.studentId, other.gpa);
        this.courses = new ArrayList<>(other.courses);
    }
    
    // Getters and Setters (encapsulation)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA! Must be between 0.0 and 4.0");
        }
    }
    
    public List<String> getCourses() {
        return new ArrayList<>(courses); // Return copy to maintain encapsulation
    }
    
    // Static getter
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public static String getUniversityName() {
        return UNIVERSITY_NAME;
    }
    
    // Method to add course
    public void addCourse(String course) {
        if (course != null && !course.trim().isEmpty() && !courses.contains(course)) {
            courses.add(course);
            System.out.println("Course '" + course + "' added for " + name);
        } else {
            System.out.println("Invalid or duplicate course!");
        }
    }
    
    // Method to remove course
    public void removeCourse(String course) {
        if (courses.remove(course)) {
            System.out.println("Course '" + course + "' removed for " + name);
        } else {
            System.out.println("Course not found!");
        }
    }
    
    // Method overloading - display with no parameters
    public void display() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
        System.out.println("Courses: " + courses);
    }
    
    // Method overloading - display with detailed flag
    public void display(boolean detailed) {
        if (detailed) {
            display();
            System.out.println("University: " + UNIVERSITY_NAME);
            System.out.println("Total Students: " + totalStudents);
        } else {
            System.out.println(name + " (ID: " + studentId + ")");
        }
    }
    
    // Method overloading - calculate grade
    public String calculateGrade() {
        if (gpa >= 3.7) return "A";
        if (gpa >= 3.0) return "B";
        if (gpa >= 2.0) return "C";
        if (gpa >= 1.0) return "D";
        return "F";
    }
    
    // Method overloading - calculate grade with passing threshold
    public String calculateGrade(double passingThreshold) {
        if (gpa >= passingThreshold) {
            return "Passing (" + calculateGrade() + ")";
        }
        return "Failing";
    }
    
    // Override toString()
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + 
               ", studentId='" + studentId + "', gpa=" + gpa + 
               ", courses=" + courses.size() + "}";
    }
    
    // Override equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }
    
    // Override hashCode()
    @Override
    public int hashCode() {
        return studentId.hashCode();
    }
}

// Immutable Address class (demonstrates immutability)
final class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    // Only getters, no setters (immutable)
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}

// Course class (demonstrates composition)
class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    
    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public int getCredits() {
        return credits;
    }
    
    @Override
    public String toString() {
        return courseCode + ": " + courseName + " (" + credits + " credits)";
    }
}

// Advanced Student class with composition
class AdvancedStudent {
    private Student student;
    private Address address;
    private List<Course> enrolledCourses;
    
    public AdvancedStudent(Student student, Address address) {
        this.student = student;
        this.address = address;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        student.addCourse(course.getCourseName());
    }
    
    public void displayFullInfo() {
        student.display();
        System.out.println("Address: " + address);
        System.out.println("Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course);
        }
    }
}

public class OOPExample {
    public static void main(String[] args) {
        System.out.println("=== Advanced OOP Example ===");
        System.out.println("============================\n");
        
        // Demonstrate encapsulation and constructors
        System.out.println("--- Creating Students ---");
        Student student1 = new Student("Rahul Sharma", 20, "STU001", 3.8);
        Student student2 = new Student(); // Default constructor
        student2.setName("Priya Patel");
        student2.setAge(21);
        student2.setStudentId("STU002");
        student2.setGpa(3.5);
        
        // Demonstrate copy constructor
        Student student3 = new Student(student1);
        student3.setName("Amit Kumar");
        student3.setStudentId("STU003");
        
        // Demonstrate getters/setters with validation
        System.out.println("\n--- Student Information ---");
        student1.display();
        student2.display();
        student3.display();
        
        // Demonstrate method overloading
        System.out.println("\n--- Method Overloading ---");
        student1.display(true);
        student2.display(false);
        
        System.out.println("\n--- Grade Calculation ---");
        System.out.println(student1.getName() + "'s grade: " + student1.calculateGrade());
        System.out.println(student2.getName() + "'s grade: " + student2.calculateGrade(2.0));
        
        // Demonstrate course management
        System.out.println("\n--- Course Management ---");
        student1.addCourse("Java Programming");
        student1.addCourse("Data Structures");
        student1.addCourse("Database Systems");
        student1.addCourse("Java Programming"); // Duplicate - should not add
        
        student1.display();
        
        // Demonstrate static members
        System.out.println("\n--- Static Members ---");
        System.out.println("Total Students: " + Student.getTotalStudents());
        System.out.println("University: " + Student.getUniversityName());
        
        // Demonstrate toString() and equals()
        System.out.println("\n--- toString() and equals() ---");
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        
        Student student4 = new Student("Rahul Sharma", 20, "STU001", 3.8);
        System.out.println("student1 equals student4: " + student1.equals(student4));
        System.out.println("student1 equals student2: " + student1.equals(student2));
        
        // Demonstrate immutability
        System.out.println("\n--- Immutable Address ---");
        Address address = new Address("123 Main St", "Mumbai", "MH", "400001");
        System.out.println("Address: " + address);
        
        // Demonstrate composition
        System.out.println("\n--- Composition with AdvancedStudent ---");
        Course javaCourse = new Course("CS101", "Java Programming", 3);
        Course dsCourse = new Course("CS102", "Data Structures", 4);
        
        AdvancedStudent advStudent = new AdvancedStudent(student1, address);
        advStudent.enrollCourse(javaCourse);
        advStudent.enrollCourse(dsCourse);
        advStudent.displayFullInfo();
        
        System.out.println("\n=== OOP Concepts Demonstrated ===");
        System.out.println("✓ Encapsulation (private fields, getters/setters)");
        System.out.println("✓ Constructors (default, parameterized, copy)");
        System.out.println("✓ Method Overloading");
        System.out.println("✓ Static Members");
        System.out.println("✓ Object Composition");
        System.out.println("✓ toString() and equals() overriding");
        System.out.println("✓ Immutability");
    }
}