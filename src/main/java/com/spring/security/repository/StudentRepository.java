package com.spring.security.repository;

import com.spring.security.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGuardianName(String guardianName);

    //JPQL Query
    @Query("select s from Student s where s.email=?1")
    Student getStudentByEmail(String email);

    // Native Query
    @Query(value = "select * from student_tbl std where std.email_address= ?1", nativeQuery = true)
    Student getStudentByEmailNativeQuery(String email);

    // Native Named Parameter Query
    @Query(value = "select * from student_tbl std where std.email_address= :emailId", nativeQuery = true)
    Student getStudentByEmailNativeNamedParamQuery(@Param("emailId") String emailId);
}
