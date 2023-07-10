package com.spring.security.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "student_tbl")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdId;
    private String fName;
    private String lName;
    @Column(name = "email_address", nullable = false)
    private String email;
    @Embedded
    private Guardian guardian;

}
