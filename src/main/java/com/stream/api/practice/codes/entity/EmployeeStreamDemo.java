package com.stream.api.practice.codes.entity;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeStreamDemo {
    public List<Employee> employeeDetails() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 70000, 30, Arrays.asList("Java", "Spring")),
                new Employee(2, "Bob", "HR", 50000, 35, Arrays.asList("Recruitment", "Management")),
                new Employee(3, "Charlie", "Engineering", 80000, 25, Arrays.asList("Python", "Django")),
                new Employee(4, "Diana", "Finance", 60000, 28, Arrays.asList("Accounting", "Excel")),
                new Employee(5, "Eve", "Engineering", 75000, 32, Arrays.asList("C++", "Linux"))
        );
        return employees;
    }
}
