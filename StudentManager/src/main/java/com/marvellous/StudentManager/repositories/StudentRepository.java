package com.marvellous.StudentManager.repositories;


import com.marvellous.StudentManager.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
