package com.example;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        // Adding new employees
        Employee emp1 = new Employee();
        emp1.setName("John Doe");
        emp1.setAge(30);
        emp1.setPosition("Developer");
        emp1.setSalary(5000f);

        dao.addEmployee(emp1);

        // Fetch and display employees
        dao.getAllEmployees().forEach(emp -> {
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Age: " + emp.getAge());
            System.out.println("Position: " + emp.getPosition());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("-----------");
        });
    }
}