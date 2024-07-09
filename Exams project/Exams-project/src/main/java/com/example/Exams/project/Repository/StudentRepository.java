package com.example.Exams.project.Repository;

import com.example.Exams.project.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {  // Change Integer to Long
    void deleteById(Long id);

    boolean existsById(Long id);
}

