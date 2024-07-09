package com.example.Exams.project.Controller;

import com.example.Exams.project.Model.Course;
import com.example.Exams.project.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/post")
    public Course postCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/get")
    public List<Course> listCourse() {
        return courseService.listCourses();
    }

    @GetMapping("/count-course")
    public long countCourse() {
        return courseService.countCourses();
    }

    @DeleteMapping("/delete-course")
    public void deleteCourse(@RequestBody Course course) {
        courseService.deleteCourse(course);
    }

    @PutMapping("/course/{code}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @GetMapping("/student/{id}")
    public Optional<Course> findCourseById(@PathVariable int id) {
        return courseService.findCourseById(id);
    }
}
