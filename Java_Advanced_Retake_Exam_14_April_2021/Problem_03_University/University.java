package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_14_April_2021.Problem_03_University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String registerStudent(Student student) {
        String out = "";
        if (this.capacity > students.size()) {
            if (students.contains(student)) {
                out = "Student is already in the university";
            } else {
                students.add(student);
                out = "Added student " + student.getFirstName() + " " + student.getLastName();
            }
        } else {
            out = "No seats in the university";
        }

        return out;
    }

    public String dismissStudent(Student student) {
        String out = "";
        if (students.contains(student)) {
            students.remove(student);
            out = "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            out = "Student not found";
        }
        return out;
    }

    public String getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student.toString();
            }
        }
        return null;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        for (Student student : students) {
            out.append("==Student: First Name = " + student.getFirstName() + ", Last Name = " + student.getLastName() + ", Best Subject = " + student.getBestSubject()).append(System.lineSeparator());
        }
        return out.toString();
    }
}
