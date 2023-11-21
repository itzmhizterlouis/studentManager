package com.marvellous.StudentManager.models.entities;

import com.marvellous.StudentManager.models.enums.HealthStatus;
import com.marvellous.StudentManager.models.enums.ScholarshipStatus;
import com.marvellous.StudentManager.models.responses.StudentResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {

    private String firstName;
    private String lastName;
    private String matricNumber;
    private String address;
    private String city;
    private int age;
    private String courseName;
    private double GPA;
    private long fees;
    private ScholarshipStatus scholarshipStatus;
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
