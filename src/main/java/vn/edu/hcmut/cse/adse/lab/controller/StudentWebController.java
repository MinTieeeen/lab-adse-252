package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        // Lấy dữ liệu từ service
        List<StudentEntity> students;
        // Kiếm tra có đang thực hiện chức năng search không?
        if(keyword != null && !keyword.isEmpty()){
            students = service.searchByName(keyword);
        } else students = service.getAll();

        // Đóng gói dữ liệu vào model để chuyển sang View
        // Key "dsSinhVien" sẽ được sử dụng bên HTML
        model.addAttribute("dsSinhVien", students);
        return "students";
    }


}
