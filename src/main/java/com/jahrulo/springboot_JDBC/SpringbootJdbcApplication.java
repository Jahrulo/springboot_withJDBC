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

		// Create and add students
		Student student1 = context.getBean(Student.class);
		student1.setStudentId(1);
		student1.setName("Johny Moly");
		student1.setAge(25);
		studentService.addStudent(student1);

		Student student2 = context.getBean(Student.class);
		student2.setStudentId(2);
		student2.setName("Mickey Singh");
		student2.setAge(45);
		studentService.addStudent(student2);

		Student student3 = context.getBean(Student.class);
		student3.setStudentId(3);
		student3.setName("Ray Jahrulo");
		student3.setAge(75);
		studentService.addStudent(student3);

		Student student4 = context.getBean(Student.class);
		student4.setStudentId(4);
		student4.setName("Mabinty Ish Conteh");
		student4.setAge(26);
		studentService.addStudent(student4);

		// Retrieve and print one student
		Student retrievedStudent = studentService.getStudent(1);
		System.out.println("\nRetrieved Student by ID: " + retrievedStudent);

		// Update student
		System.out.println("\nUpdating student with ID ");
		Student studentToUpdate = studentService.getStudent(3);
		studentToUpdate.setName("Ray Jahrulo");
		studentToUpdate.setAge(80);
		studentService.updateStudent(studentToUpdate);

		// List all students after update
		System.out.println("\nAll Students after update:");
		List<Student> allStudents = studentService.getAllStudents();
		allStudents.forEach(System.out::println);

		// Delete a student
		System.out.println("\nDeleting student with ID 2...");
		studentService.deleteStudent(2);

		// List all students after deletion
		System.out.println("\nAll Students after deletion:");
		allStudents = studentService.getAllStudents();
		allStudents.forEach(System.out::println);
	}
}