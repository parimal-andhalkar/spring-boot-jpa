package com.boot.jpa.springbootjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.boot.jpa.springbootjpa.dao.StudentDao;
import com.boot.jpa.springbootjpa.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Student registerOrUpdateStudent(Student student)
	{
		Student st = studentDao.save(student);
		
		return st;
	}
	
	public Student getStudent(int id)
	{
	 	Optional<Student> optionalStudnet = studentDao.findById(id);
	 	if(optionalStudnet.isPresent())
	 		return optionalStudnet.get();
	 	else 
	 		return null;
	}
	
	public void deleteStudent(int id) {
		
		Student student = getStudent(id);
		if(student==null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No resource found for id (%s)", id));	
		studentDao.delete(student);
	}
	
	public String getStudentNative(int id) {
		
		return studentDao.getStudentFirstName(id);
	}
	
public void updateStudentNative(int id,String fname) {
		
		studentDao.updateStudent(id, fname);
	}
}
