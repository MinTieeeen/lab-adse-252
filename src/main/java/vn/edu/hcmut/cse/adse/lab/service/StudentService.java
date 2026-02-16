package vn.edu.hcmut.cse.adse.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adse.lab.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<StudentEntity> getAll() {
        return repository.findAll();
    }

    public StudentEntity getStudentById(String id){
        return repository.findById(id).orElse(null);
    }

    public List<StudentEntity> searchByName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }
}
