package com.spring.security;

import com.spring.security.entity.Course;
import com.spring.security.entity.CourseMaterial;
import com.spring.security.entity.Teacher;
import com.spring.security.repository.CourseMaterialRepository;
import com.spring.security.repository.CourseRepository;
import com.spring.security.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseAndCourseMaterialRepositortTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseMaterialRepository materialRepository;

    private Course saveCourse() {
        return Course.builder()
                .courseTitle("Spring Data Jpa")
                .credit(241100)
                .build();
    }

    @Test
    public void saveCourseMaterial() {
        CourseMaterial material = CourseMaterial.builder()
                .url("https://spring-data-jpa.java")
                .course(saveCourse())
                .build();
        materialRepository.save(material);
    }

    @Test
    public void printAllCourses() {
        System.out.println("All Courses Material: " + materialRepository.findAll());
        System.out.println("All Courses: " + courseRepository.findAll());
    }


    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .teacherFirstName("Giri Sir")
                .teacherLastName("Paithn")
                .build();

        Course course = Course.builder()
                .courseTitle("Spring boot Microservices with Spring Security")
                .credit(5)
                .teacher(teacher)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("Spring.io").course(course).build();

        materialRepository.save(courseMaterial);
    }

    @Test
    public void printTeachers() {
        System.out.println("Get all teachers: " + teacherRepository.findAll());
        System.out.println("Get all Courses: " + courseRepository.findAll());
    }


}
