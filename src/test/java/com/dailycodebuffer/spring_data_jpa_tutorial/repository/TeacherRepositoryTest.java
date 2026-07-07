package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Course;
import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course course=Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava=Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Yuvan")
                .lastName("Shankar")
//                .courses(List.of(course,courseJava))
                .build();

        teacherRepository.save(teacher);


    }

}