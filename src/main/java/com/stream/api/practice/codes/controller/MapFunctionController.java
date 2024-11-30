package com.stream.api.practice.codes.controller;

import com.stream.api.practice.codes.coding.Map_Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/map-function")
public class MapFunctionController {
    @Autowired
    private Map_Function mapFunction;

    // 1. Get the names of all employees
    @GetMapping("/employees/names")
    public List<String> getEmployeeNames() {
        return mapFunction.namesOfEmployees();
    }

    // 2. Convert all employee names to uppercase
    @GetMapping("/employees/names-uppercase")
    public List<String> getNamesInUppercase() {
        return mapFunction.namesToUppercase();
    }

    // 3. Increase each employee's salary by 10%
    @GetMapping("/employees/salaries/increased")
    public List<Double> getIncreasedSalaries() {
        return mapFunction.increaseSalary();
    }

    // 4. Get a list of all departments
    @GetMapping("/employees/departments")
    public List<String> getDepartments() {
        return mapFunction.getDepartments();
    }

    // 5. Extract all employee skills
    @GetMapping("/employees/skills")
    public List<List<String>> getEmployeeSkills() {
        return mapFunction.getEmployeeSkills();
    }

    // 6. Create a formatted string with employee names and salaries
    @GetMapping("/employees/names-salaries")
    public List<String> getNamesAndSalaries() {
        return mapFunction.getNamesAndSalaries();
    }

    // 7. Get a list of all employee IDs
    @GetMapping("/employees/ids")
    public List<Integer> getEmployeeIds() {
        return mapFunction.getEmployeeIds();
    }

    // 8. Convert employee salaries to formatted strings
    @GetMapping("/employees/salaries/formatted")
    public List<String> getFormattedSalaries() {
        return mapFunction.getFormattedSalaries();
    }

    // 9. Get the first skill of each employee
    @GetMapping("/employees/skills/first")
    public List<String> getFirstSkills() {
        return mapFunction.getFirstSkills();
    }

    // 10. Prefix "Employee: " to each employee's name
    @GetMapping("/employees/names-prefixed")
    public List<String> getPrefixedNames() {
        return mapFunction.getPrefixedNames();
    }
}
