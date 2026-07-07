package com.dailycodebuffer.spring_data_jpa_tutorial.controller;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import com.dailycodebuffer.spring_data_jpa_tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${db_username}")
    private String dbUsername;

    @Value("${db_name}")
    private String dbName;

    // Test if application is running
    @GetMapping("/")
    public String home() {
        return "Spring Boot Application is Running Successfully!";
    }

    // Verify AWS Secrets Manager values
    @GetMapping("/secret")
    public String secret() {
        return "Database : " + dbName + " | Username : " + dbUsername;
    }

    // Fetch students by first name
    @GetMapping
    public List<Student> getStudentByFirstName(@RequestParam String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    // Health check endpoint
    @GetMapping("/health")
    public String health() {
        return "Application is UP";
    }

    // Show which server handled the request
    @GetMapping("/server")
    public String server() throws Exception {
        return "Request served by : " + InetAddress.getLocalHost().getHostName();
    }
}