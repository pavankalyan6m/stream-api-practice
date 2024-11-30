package com.stream.api.practice.codes.controller;

import com.stream.api.practice.codes.coding.Files_Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/files-operations")
public class FileOperationsController {
    @Autowired
    private Files_Operations filesOperations;

    // Endpoint to get all lines from a file
    @GetMapping("/read-file")
    public List<String> getFileLines() {
        // Read lines from the file and collect them into a List
        return filesOperations.stringsInFile().collect(Collectors.toList());
    }

    // Endpoint to filter and get .txt files in the directory
    @GetMapping("/filter-files")
    public List<Path> filterFiles() {
        try {
            // Get filtered .txt files and collect them into a List
            return filesOperations.filterFiles().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error filtering files", e);
        }
    }

    // Endpoint to count the number of lines in the file
    @GetMapping("/count-lines")
    public Long countFileLines() {
        try {
            // Get the number of lines in the file
            return filesOperations.countLines();
        } catch (IOException e) {
            throw new RuntimeException("Error counting lines", e);
        }
    }

    // Endpoint to map the contents of the file to uppercase
    @GetMapping("/map-contents")
    public List<String> mapFileContents() {
        try {
            // Get mapped content and collect to a List
            return filesOperations.mapContents().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error mapping contents", e);
        }
    }

    @GetMapping("/skip/{lines}")
    public Stream<String> skipLines(@PathVariable int lines) throws IOException {
        return filesOperations.skipNLines(lines);
    }

}
