package com.jahrulo.springboot_JDBC;

import com.jahrulo.springboot_JDBC.Models.Student;
import com.jahrulo.springboot_JDBC.Services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJdbcApplication.class, args);

		StudentService studentService = context.getBean(StudentService.class);

		// Create and add a student
		Student student = context.getBean(Student.class);
		student.setStudentId(1);
		student.setName("Johny Moly");
		student.setAge(25);
		studentService.addStudent(student);

		Student student2 = context.getBean(Student.class);
		student2.setStudentId(2);
		student2.setName("Mickey Singh");
		student2.setAge(45);
		studentService.addStudent(student2);

		// Retrieve one and print the student
		Student retrievedStudent = studentService.getStudent(1);
		System.out.println("Retrieved Student: " + retrievedStudent);

		// List of students
		List<Student> allStudents = studentService.getAllStudents();

        // Print all students
		System.out.println("All Students:");
		allStudents.forEach(System.out::println);

	}
}