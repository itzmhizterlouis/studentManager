package com.marvellous.StudentManager.models.responses;

import com.marvellous.StudentManager.models.enums.HealthStatus;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String matricNumber;
    private String courseName;
    private HealthStatus healthStatus;
}
