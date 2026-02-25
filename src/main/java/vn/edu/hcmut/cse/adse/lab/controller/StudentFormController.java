package vn.edu.hcmut.cse.adse.lab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentFormController {
    @Autowired
    private StudentService service;
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("student", new StudentEntity());
        return "student-form";
    }

    @PostMapping
    public String createStudent(@ModelAttribute StudentEntity student){
        service.add(student);
        return "redirect:/students";
    }
}
