package com.example.Exams.project.Services;

import com.example.Exams.project.Model.Course;
import com.example.Exams.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public long countCourses() {
        return courseRepository.count();
    }

    public Course updateCourse(int id, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course updatedCourse = existingCourse.get();
            updatedCourse.setCourseName(course.getCourseName());
            updatedCourse.setCourseCode(course.getCourseCode());
            updatedCourse.setStudent(course.getStudent()); // Assuming you want to update the student association
            // You can update other fields as necessary
            return courseRepository.save(updatedCourse);
        } else {
            throw new RuntimeException("Course not found with id " + id);
        }
    }

    public Optional<Course> findCourseById(int id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }
}
