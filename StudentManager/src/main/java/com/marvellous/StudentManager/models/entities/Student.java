package com.marvellous.StudentManager.models.entities;

import com.marvellous.StudentManager.models.enums.HealthStatus;
import com.marvellous.StudentManager.models.enums.ScholarshipStatus;
import com.marvellous.StudentManager.models.responses.StudentResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {

    @Column
    private String firstName;
    private String lastName;
    private String matricNumber;
    private String address;
    private String city;
    private String state;
    private int age;
    private String courseName;
    private double gpa;
    private long fees;

    @Enumerated(EnumType.ORDINAL)
    private ScholarshipStatus scholarshipStatus;
    @Enumerated(EnumType.STRING)
    private HealthStatus healthStatus;
    private String club;

    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public StudentResponse toDto(){
        return StudentResponse.builder()
                .id(id)
                .firstName(firstName)
                .matricNumber(matricNumber)
                .lastName(lastName)
                .courseName(courseName)
                .healthStatus(healthStatus)
                .build();
    }
}
