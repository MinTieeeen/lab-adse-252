package vn.edu.hcmut.cse.adse.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmut.cse.adse.lab.entity.StudentEntity;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    List<StudentEntity> findByNameContainingIgnoreCase(String name);
}
