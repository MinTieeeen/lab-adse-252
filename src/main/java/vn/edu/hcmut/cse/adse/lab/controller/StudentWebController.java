package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    @Autowired
    private StudentService service;

    // Route: GET http://localhost:8080/students
    @GetMapping
    public String getAllStudents(Model model) {
        // Lấy dữ liệu từ service
        List<StudentEntity> students = service.getAll();

        // Đóng gói dữ liệu vào model để chuyển sang View
        // Key "dsSinhVien" sẽ được sử dụng bên HTML
        model.addAttribute("dsSinhVien", students);
        return "students";
    }
}
