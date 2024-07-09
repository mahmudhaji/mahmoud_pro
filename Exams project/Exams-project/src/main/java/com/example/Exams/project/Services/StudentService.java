package com.example.Exams.project.Services;

import com.example.Exams.project.Model.Student;
import com.example.Exams.project.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public Student updateStudent(int id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById((long) id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setStudentName(student.getStudentName());
            updatedStudent.setStudentRegistrationNumber(student.getStudentRegistrationNumber());
            // You can update other fields as necessary
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    public Optional<Student> findStudentById(int id) {
        return studentRepository.findById((long) id);
    }

    @Transactional
    public void deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        } else {
            throw new IllegalArgumentException("Student with id " + studentId + " does not exist.");
        }
    }


}
