package com.spring.security;

import com.spring.security.entity.Guardian;
import com.spring.security.entity.Student;
import com.spring.security.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {

    public static final String GUARDIAN_MAIL = "rnyewale@gmail.com";

    public static final String MY_EMAIL = "vedanti.yewale@vedu-enterprises.com";

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Priya")
                .lastName("Yewale")
                .email("priya.yewale@vedu-enterprises.com")
                .guardian(getGuardianDetails())
                .build();
        Student response = studentRepository.save(student);
        System.out.println("Student saved successfully to database: " + response);
    }

    private Guardian getGuardianDetails() {
        return Guardian.builder()
                .name("Ram")
                .email(GUARDIAN_MAIL)
                .mobile("9921253518")
                .build();
    }

    @Test
    public void getStudentByEmail() {
        System.out.println("Find Student By Email: " + studentRepository.getStudentByEmail(MY_EMAIL));
    }

    @Test
    public void getByGuardianName() {
        System.out.println("Get Student by Guardian Name: " + studentRepository.findByGuardianName("Ram"));
    }

    @Test
    public void getStudentByEmailNativeQuery() {
        System.out.println("Find Student By Email: " + studentRepository.getStudentByEmailNativeQuery(MY_EMAIL));
    }

    @Test
    public void getStudentByEmailNativeNamedParameterQuery() {
        System.out.println("Find Student By Email: " + studentRepository.getStudentByEmailNativeNamedParamQuery(MY_EMAIL));
    }

    @Test
    public void updateStudentNameByEmail(){
        System.out.println("Student updated: "+ studentRepository.updateStudentNameByEmailId("Madhu","priya.yewale@vedu-enterprises.com"));
    }

}
