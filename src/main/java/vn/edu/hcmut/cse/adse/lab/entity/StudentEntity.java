package vn.edu.hcmut.cse.adse.lab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    private String Id; // Sử dụng string, không dùng @GeneratedValue
    private String name;
    @Column(unique = true)
    private String email;
    private int age;
}
