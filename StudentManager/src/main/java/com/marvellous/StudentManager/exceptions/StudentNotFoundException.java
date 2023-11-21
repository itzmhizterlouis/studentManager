package com.marvellous.StudentManager.exceptions;

public class StudentNotFoundException extends EntityNotFoundException{


    public StudentNotFoundException() {
        super("Student with the inputted ID not found");
    }
}
