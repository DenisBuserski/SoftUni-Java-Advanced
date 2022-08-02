package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_18_August_2021.Problem_3_Cafe;

public class Main {

    public static void main(String[] args) {

        //Initialize the repository
        Cafe cafe = new Cafe("Costa", 15);
//Initialize entity
        Employee employee = new Employee("Alexander", 30, "Bulgaria");
//Print Employee
        System.out.println(employee); // Employee: Alexander, 30 from Bulgaria

//Add Employee
        cafe.addEmployee(employee);

//Remove Employee
        System.out.println(cafe.removeEmployee("Employee")); //false

        Employee secondEmployee = new Employee("Sara", 24, "UK");
        Employee thirdEmployee = new Employee("Anna", 22, "Germany");

//Add Employee
        cafe.addEmployee(secondEmployee);
        cafe.addEmployee(thirdEmployee);

        Employee oldestEmployee = cafe.getOldestEmployee();
        Employee employeeStephen = cafe.getEmployee("Sara");
        System.out.println(oldestEmployee); // Employee: Alexander, 30 from Bulgaria System.out.println(employeeStephen); //Employee: Sara, 24 from UK

        System.out.println(cafe.getCount()); // 3
        System.out.println(cafe.removeEmployee("Anna")); // true

        System.out.println(cafe.report());
//Employees working at Cafe Costa:
//Employee: Alexander, 30 from Bulgaria
//Employee: Sara, 24 from UK

    }
}
