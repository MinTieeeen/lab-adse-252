package vn.edu.hcmut.cse.adse.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adse.lab.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<StudentEntity> getAll() {
        return repository.findAll();
    }

    public StudentEntity getStudentById(String id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Sinh viên không tìm thấy!"
        ));
    }

    public List<StudentEntity> searchByName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    public StudentEntity add(StudentEntity student) {
        return repository.save(student);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
