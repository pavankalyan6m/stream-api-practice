package com.stream.api.practice.codes.coding;


import com.stream.api.practice.codes.entity.Employee;
import com.stream.api.practice.codes.entity.EmployeeStreamDemo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//The map method is used to return a stream, consisting of the results of
// applying the given function to the elements
@Service
public class Map_Function {
    //<R> Stream<R> map(Function<? super T, ? extends R> mapper)
    @Autowired
    private EmployeeStreamDemo employeeStreamDemo;

    private List<Employee> employees;

    @PostConstruct
    public void init() {
        employees = employeeStreamDemo.employeeDetails();
    }

    //1.Scenario: Get the names of all employees.
    public List<String> namesOfEmployees() {

        List<String> names_of_employees = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Names of employees: " + names_of_employees);

        return names_of_employees;
    }

    //2.Scenario: Convert all employee names to uppercase.
    public List<String> namesToUppercase() {

        List<String> convert_names_to_uppercase = employees.stream()
                .map(employee -> employee.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Uppercase Names of employees: " + convert_names_to_uppercase);

        return convert_names_to_uppercase;
    }


    //3. Scenario: Increase each employee's salary by 10%.
    public List<Double> increaseSalary() {
        List<Double> salary = employees.stream()
                .map(employee -> employee.getSalary() * 1.10)
                .collect(Collectors.toList());
        System.out.println("Increasing employee salary by 10%: " + salary);
        return salary;
    }

    //4.Scenario: Get a list of all departments.
    public List<String> getDepartments() {
        List<String> departmentsList = employees.stream()
                .map(employee -> employee.getDepartment())
                .collect(Collectors.toList());
        System.out.println("DepartmentsList: "+departmentsList);
        return departmentsList;
    }

    //5.Scenario: Extract all employee skills as lists.
    public List<List<String>> getEmployeeSkills() {
        List<List<String>> employeeSkills = employees.stream()
                .map(employee -> employee.getSkills())
                .collect(Collectors.toList());
        System.out.println("List of Skills: "+employeeSkills);
        return employeeSkills;
    }

    //6. Scenario: Create a formatted string with each employee's name and salary.
    public List<String> getNamesAndSalaries() {
        List<String> namesAndSalaries = employees.stream()
                .map(employee -> employee.getName() + " earns: "+ employee.getSalary())
                .collect(Collectors.toList());
        System.out.println("Names & Salaries: "+namesAndSalaries);
        return namesAndSalaries;
    }

    //7. Scenario: Get a list of all employee IDs.
    public List<Integer> getEmployeeIds() {
        List<Integer> employeeIds = employees.stream()
                .map(employee -> employee.getId())
                .collect(Collectors.toList());
        System.out.println("Employee IDs: "+employeeIds);
        return employeeIds;
    }

    //8. Scenario: Convert employee salaries to formatted strings (e.g., "$70,000").
    public List<String> getFormattedSalaries() {
        List<String> formattedSalaries = employees.stream()
                .map(employee -> "$"+employee.getSalary())
                .collect(Collectors.toList());
        System.out.println("Formatted Salaries list fo employees : "+formattedSalaries);
        return formattedSalaries;
    }

    //9. Scenario: Get the first skill of each employee.
    public List<String> getFirstSkills() {
        List<String> firstSkills = employees.stream()
                .map(employee -> employee.getSkills().isEmpty() ? "No Skills" : employee.getSkills().get(0))
                .collect(Collectors.toList());
        System.out.println("first Skills are: "+firstSkills);
        return firstSkills;
    }

    //10. Scenario: Prefix "Employee: " to each employee's name
    public List<String> getPrefixedNames() {
        List<String> getPrefixedNames = employees.stream()
                .map(employee -> "Employee: " + employee.getName())
                .collect(Collectors.toList());
        System.out.println("Prefix added names: "+getPrefixedNames);
        return getPrefixedNames;
    }
}
