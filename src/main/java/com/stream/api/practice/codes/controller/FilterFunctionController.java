package com.stream.api.practice.codes.controller;

import com.stream.api.practice.codes.coding.Filter_Function;
import com.stream.api.practice.codes.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filter-function")
public class FilterFunctionController {
    @Autowired
    private Filter_Function filterFunction;

    // 1. Endpoint: Filter employees who earn more than $60,000
    @GetMapping("/employees/filter/salary")
    public List<Employee> filterSalary() {
        return filterFunction.filterSalary();
    }

    // 2. Endpoint: Get employees working in the "Engineering" department
    @GetMapping("/employees/filter/department")
    public List<Employee> filterDepartment() {
        return filterFunction.filterDepartment();
    }

    // 3. Endpoint: Filter employees who are younger than 30 years old
    @GetMapping("/employees/filter/age")
    public List<Employee> filterAge() {
        return filterFunction.filterAge();
    }

    // 4. Endpoint: Get employees who have "Java" as a skill
    @GetMapping("/employees/filter/skills")
    public List<Employee> filterSkills() {
        return filterFunction.filterSkills();
    }

    // 5. Endpoint: Get employees who work in the "Engineering" department and earn more than $70,000
    @GetMapping("/employees/filter/engineering-high-salary")
    public List<Employee> filterEngineeringHighSalary() {
        return filterFunction.filterEmployees();
    }

}
