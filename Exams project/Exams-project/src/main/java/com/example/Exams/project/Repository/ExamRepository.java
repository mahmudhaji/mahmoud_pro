package com.example.Exams.project.Repository;

import com.example.Exams.project.Model.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exams,Integer> {
}
