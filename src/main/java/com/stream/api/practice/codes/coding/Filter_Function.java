package com.stream.api.practice.codes.coding;

import com.stream.api.practice.codes.entity.Employee;
import com.stream.api.practice.codes.entity.EmployeeStreamDemo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Filter_Function {
    @Autowired
    private EmployeeStreamDemo employeeStreamDemo;

    private List<Employee> employees;

    @PostConstruct
    public void init() {
        employees = employeeStreamDemo.employeeDetails();
    }

    //1. Scenario: Filter employees who earn more than $60,000.
    public List<Employee> filterSalary() {
        List<Employee> filteredSalary = employees.stream()
                .filter(employee -> employee.getSalary() > 60000)
                .collect(Collectors.toList());
        return filteredSalary;
    }

    //2. Scenario: Get employees working in the "Engineering" department.
    public List<Employee> filterDepartment() {
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Engineering"))
                .collect(Collectors.toList());
        return filteredEmployees;
    }

    //3. Scenario: Filter employees who are younger than 30 years old.
    public List<Employee> filterAge() {
        List<Employee> filterAge = employees.stream().
                filter(employee -> employee.getAge() < 30)
                .collect(Collectors.toList());
        return filterAge;
    }

    //4. Scenario: Get employees who have "Java" as a skill.
    public List<Employee> filterSkills() {
        List<Employee> filterSkills = employees.stream()
                .filter(employee -> employee.getSkills().contains("Java"))
                .collect(Collectors.toList());
        return filterSkills;
    }

    //5. Scenario: Get employees who work in the "Engineering" department and earn more than $70,000.
    public List<Employee> filterEmployees() {
        List<Employee> filterEmployees = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Engineering") && employee.getSalary() > 70000)
                .collect(Collectors.toList());
        return filterEmployees;
    }
}
