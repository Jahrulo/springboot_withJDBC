package com.jahrulo.springboot_JDBC.Services;

import com.jahrulo.springboot_JDBC.Models.Student;
import com.jahrulo.springboot_JDBC.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repository;

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        repository.createStudent(student);
    }

    public Student getStudent(int id) {
        return repository.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return repository.listStudents();
    }

    public void updateStudent(Student student) {
        repository.updateStudent(student);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}