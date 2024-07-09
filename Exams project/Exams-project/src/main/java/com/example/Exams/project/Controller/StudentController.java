package com.example.Exams.project.Controller;

import com.example.Exams.project.Model.Student;
import com.example.Exams.project.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

//    http://localhost:8080/api/v1/student/post-student

    @Autowired
    private StudentService studentService;

    @PostMapping("/post-student")
    public Student postStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/get-student")
    public List<Student> listStudents() {
        return studentService.listStudents();
    }

    @GetMapping("/count-students")
    public long countStudents() {
        return studentService.countStudents();
    }

    @DeleteMapping("/delete-students/{studentId}")
    public ResponseEntity<String> deleteStudents(@PathVariable Long studentId) {  // Ensure Long type here
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok("Student deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/students/{id}")
    public Optional<Student> findStudentById(@PathVariable int id) {
        return studentService.findStudentById(id);
    }
}
