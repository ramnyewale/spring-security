package com.spring.security;

import com.spring.security.model.Guardian;
import com.spring.security.model.Student;
import com.spring.security.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .fName("VEDANTI")
                .lName("Yewale")
                .email("vedanti@gmail.com")
                .guardian(getGuardianDetails())
                .build();
        Student response = studentRepository.save(student);
        System.out.println("Student saved successfully to database: " + response);
    }

    private Guardian getGuardianDetails() {
        return Guardian.builder()
                .name("Ram Yewale")
                .email("rnyewale@gmail.com")
                .mobile("9921253518")
                .build();
    }
}
