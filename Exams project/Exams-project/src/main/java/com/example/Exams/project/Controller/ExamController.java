package com.example.Exams.project.Controller;

import com.example.Exams.project.Model.Exams;
import com.example.Exams.project.Services.ExamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ExamController {

    @Autowired
    private ExamsService examsService;

    @PostMapping("/exam")
    public Exams postExams(@RequestBody Exams exams) {
        return examsService.saveExams(exams);
    }

    @GetMapping("/list-exams")
    public List<Exams> listExams() {
        return examsService.listExams();
    }

    @GetMapping("/count-exams")
    public long countExams() {
        return examsService.countExams();
    }

    @DeleteMapping("/delete-exams")
    public void deleteExams(@RequestBody Exams exams) {
        examsService.deleteExams(exams);
    }

    @PutMapping("/exam/{id}")
    public Exams updateExam(@PathVariable int id, @RequestBody Exams exams) {
        return examsService.updateExams(id, exams);
    }

    @GetMapping("/exam/{id}")
    public Optional<Exams> findExamById(@PathVariable int id) {
        return examsService.findExamById(id);
    }
}
