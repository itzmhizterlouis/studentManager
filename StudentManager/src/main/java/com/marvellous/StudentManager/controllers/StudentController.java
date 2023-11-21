package com.marvellous.StudentManager.controllers;

import com.marvellous.StudentManager.exceptions.StudentNotFoundException;
import com.marvellous.StudentManager.models.entities.Student;
import com.marvellous.StudentManager.models.responses.StudentResponse;
import com.marvellous.StudentManager.services.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponse createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<StudentResponse> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id) throws StudentNotFoundException {
        return studentService.getStudent(id);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) throws StudentNotFoundException {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public StudentResponse deleteStudent(@PathVariable long id) throws StudentNotFoundException{

        return studentService.deleteStudent(id);
    }
}
