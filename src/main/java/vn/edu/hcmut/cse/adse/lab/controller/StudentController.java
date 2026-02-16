package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService service;

    // GET: /api/students
    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return service.getAll();
    }

    // GET: /api/students/{id}
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentEntity getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    
}
