package com.example.Exams.project.Services;

import com.example.Exams.project.Model.Exams;
import com.example.Exams.project.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamsService {

    @Autowired
    private ExamRepository examsRepository;

    public Exams saveExams(Exams exams) {
        return examsRepository.save(exams);
    }

    public List<Exams> listExams() {
        return examsRepository.findAll();
    }

    public long countExams() {
        return examsRepository.count();
    }

    public Exams updateExams(int id, Exams exams) {
        Optional<Exams> existingExam = examsRepository.findById(id);
        if (existingExam.isPresent()) {
            Exams updatedExam = existingExam.get();
            updatedExam.setExamName(exams.getExamName());
            updatedExam.setExamCode(exams.getExamCode());
            // You can update other fields as necessary
            return examsRepository.save(updatedExam);
        } else {
            throw new RuntimeException("Exam not found with id " + id);
        }
    }

    public Optional<Exams> findExamById(int id) {
        return examsRepository.findById(id);
    }

    public void deleteExams(Exams exams) {
        examsRepository.delete(exams);
    }
}
