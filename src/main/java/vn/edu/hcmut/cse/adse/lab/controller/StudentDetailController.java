package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentDetailController {
    
    @Autowired
    private StudentService service;

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable String id, Model model) {
        StudentEntity student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "student-detail";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable String id, Model model){
        StudentEntity student = service.getStudentById(id);
        model.addAttribute("student",student);
        return "student-form";
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable String id, Model model) {
        service.deleteById(id);
        return "redirect:/students";
    }
}
