package com.stream.api.practice.codes.coding;

import com.stream.api.practice.codes.entity.Employee;
import com.stream.api.practice.codes.entity.EmployeeStreamDemo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class Files_Operations {
    @Autowired
    private EmployeeStreamDemo employeeStreamDemo;

    private List<Employee> employees;

    @PostConstruct
    public void init() {
        employees = employeeStreamDemo.employeeDetails();
    }

    //1. Java Stream API to read all lines from a file
    public Stream<String> stringsInFile() {
        Path path = Paths.get("src/main/resources/static/NewTextFile.txt");
        try {
            return Files.lines(path); // Return all lines from the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 2. Filter files in a directory using Java Streams and return the Stream of filtered files
    public Stream<Path> filterFiles() throws IOException {
        Path dir = Paths.get("src/main/resources/static");

        // Return a Stream of Path objects representing the filtered files
        return Files.walk(dir)
                .filter(path -> Files.isRegularFile(path) && path.toString().endsWith(".txt"));
    }

    //3. count the number of lines in a file using Java Streams
    public Long countLines() throws IOException {
        Path dir = Paths.get("src/main/resources/static/NewTextFile.txt");
        long lineCount = Files.lines(dir).count();
        return lineCount;
    }

    //4. map the contents of a file to uppercase using Java Streams
    public Stream<String> mapContents() throws IOException {
        Path dir = Paths.get("src/main/resources/static/NewTextFile.txt");
        return Files.lines(dir)
                .map(String::toUpperCase); // Print each line in uppercase
    }

    //5. skip the first N lines of a file using Java Streams
    public Stream<String> skipNLines(int lines) throws IOException {
        Path dir = Paths.get("src/main/resources/static/NewTextFile.txt");
        return Files.lines(dir)
                .skip(2);
    }


}
