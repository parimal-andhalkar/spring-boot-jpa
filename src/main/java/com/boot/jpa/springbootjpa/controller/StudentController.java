package com.boot.jpa.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.springbootjpa.exception.StudentNotFoundException;
import com.boot.jpa.springbootjpa.model.Student;
import com.boot.jpa.springbootjpa.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/hello")
	public Student hello() {
		Student student = new Student(1	, "Ram", "Tiwari");
		
		
		return student;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student)
	{
		Student student2 = studentService.registerOrUpdateStudent(student);
		return new ResponseEntity<Student>(student2,HttpStatus.CREATED);	
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id)
	{
		Student student = studentService.getStudent(id);
		if(student == null)
		{
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No resource found for id (%s)", id));
			throw new StudentNotFoundException(HttpStatus.NOT_FOUND,"No Student found for Roll Number: "+id);
		}
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		
		Student updateStudent = studentService.registerOrUpdateStudent(student);
		return new ResponseEntity<Student>(updateStudent,HttpStatus.OK);		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id)
	{
		studentService.deleteStudent(id);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/native/{id}")
	public ResponseEntity<String> getStudentNative(@PathVariable("id") int id)
	{
		String firstname = studentService.getStudentNative(id);
		if(firstname == null)
		{
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No resource found for id (%s)", id));
			throw new StudentNotFoundException(HttpStatus.NOT_FOUND,"No Student found for Roll Number: "+id);
		}
		return new ResponseEntity<String>(firstname,HttpStatus.OK);
	}
	
	@PutMapping("/native")
	public ResponseEntity<String> updateStudentNative(@RequestBody  Student student)
	{
		Student student2 = studentService.getStudent(student.getRollNo());
		studentService.updateStudentNative(student.getRollNo(), student.getFirstName());
		return new ResponseEntity<String>("updated Student",HttpStatus.OK);
	}
	
	
}
