package com.marvellous.StudentManager.services;

import com.marvellous.StudentManager.exceptions.StudentNotFoundException;
import com.marvellous.StudentManager.models.entities.Student;
import com.marvellous.StudentManager.models.responses.StudentResponse;
import com.marvellous.StudentManager.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse createStudent(Student student){
        studentRepository.save(student);
        return student.toDto();
    }

    public List<StudentResponse> getStudents(){

        List<StudentResponse> studentResponses = new ArrayList<>();
        List<Student> students = studentRepository.findAll();

        for (Student student: students){
            studentResponses.add(student.toDto());
        }

        return studentResponses;
    }

    public Student getStudent(long id) throws StudentNotFoundException {

        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public Student updateStudent(long id, Student student) throws StudentNotFoundException {

        Student updatedStudent = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setAddress(student.getAddress());
        updatedStudent.setCity(student.getCity());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setClub(student.getClub());
        updatedStudent.setFees(student.getFees());
        updatedStudent.setGpa(student.getGpa());
        updatedStudent.setHealthStatus(student.getHealthStatus());
        updatedStudent.setScholarshipStatus(student.getScholarshipStatus());
        updatedStudent.setCourseName(student.getCourseName());
        updatedStudent.setState(student.getState());

        studentRepository.save(updatedStudent);

        return updatedStudent;
    }

    public StudentResponse deleteStudent(long id) throws StudentNotFoundException {

        Student deletedStudent = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(deletedStudent);

        return deletedStudent.toDto();

    }
}
