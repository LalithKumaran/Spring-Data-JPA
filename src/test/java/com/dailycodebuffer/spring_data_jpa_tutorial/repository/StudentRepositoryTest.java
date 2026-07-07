package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Guardian;
import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("lalith@gmail.com")
                .firstName("lalith")
                .lastName("kumaran")
//                .guardianName("Jamuna")
//                .guardianEmail("jamuna@gmail.com")
//                .guardianMobile("90088888")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .name("kumar")
                .email("kumar@gmail.com")
                .mobile("9999999999")
                .build();
        Student student=Student.builder()
                .firstName("magesh")
                .lastName("bharathi")
                .emailId("magesh@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("lalith");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("ma");
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList=studentRepository.findByGuardianName("Kumar");
        System.out.println(studentList);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("lalith@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("lalith@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("lalith@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("lalith@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("lith","lalith@gmail.com");
    }



}