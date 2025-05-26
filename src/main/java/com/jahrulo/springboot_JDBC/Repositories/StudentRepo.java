package com.jahrulo.springboot_JDBC.Repositories;

import com.jahrulo.springboot_JDBC.Models.Student;
import com.jahrulo.springboot_JDBC.Models.StudentDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct  // This will run after dependency injection is done
    public void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Student (" +
                "studentId INT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "age INT)");
    }

    private final RowMapper<Student> rowMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setStudentId(rs.getInt("studentId"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    };

    @Override
    public void createStudent(Student student) throws DataAccessException {
        String sql = "INSERT INTO Student (studentId, name, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudentId(), student.getName(), student.getAge());
    }

    @Override
    public Student getStudentById(int id) throws DataAccessException {
        String sql = "SELECT * FROM Student WHERE studentId = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Student> listStudents() throws DataAccessException {
        String sql = "SELECT * FROM Student";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void updateStudent(Student student) throws DataAccessException {
        String sql = "UPDATE Student SET name = ?, age = ? WHERE studentId = ?";
        jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getStudentId());
    }

    @Override
    public void deleteStudent(int id) throws DataAccessException {
        String sql = "DELETE FROM Student WHERE studentId = ?";
        jdbcTemplate.update(sql, id);
    }
}