package com.jahrulo.springboot_JDBC.Models;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentDAO {
    void createStudent(Student student) throws DataAccessException;
    Student getStudentById(int id) throws DataAccessException;
    List<Student> listStudents() throws DataAccessException;
    void updateStudent(Student student) throws DataAccessException;
    void deleteStudent(int id) throws DataAccessException;
}