package com.example.Student_Management_System.controller;

import com.example.Student_Management_System.model.Student;
import com.example.Student_Management_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentID), HttpStatus.OK);
    }

    @PutMapping("updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted Successfully.", HttpStatus.OK);
    }

    @GetMapping("getStudentByYearsOfEnrollment/{yearsOfEnrollment}")
    public List<Student> getStudentByYearsOfExperience(@PathVariable("yearsOfEnrollment") int yearsOfEnrollment) {
        return studentService.getStudentByYearsOfExperience(yearsOfEnrollment);
    }

    @GetMapping("getDepartmentById/{id}")
    public String findStudentNameByDepartmentId(@PathVariable("id") long id) {
        return studentService.findDepartmentById(id);
    }

    @DeleteMapping("deleteStudentByYearsOfEnrollment/{yearsOfEnrollment}")
    public String deleteStudentByYearsOfEnrollment(@PathVariable("yearsOfEnrollment") int yearsOfEnrollment) {
        return studentService.deleteStudentByYearsOfEnrollment(yearsOfEnrollment);
    }
}