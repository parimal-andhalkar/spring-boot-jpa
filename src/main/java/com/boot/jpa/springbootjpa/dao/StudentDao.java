package com.boot.jpa.springbootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.jpa.springbootjpa.model.Student;

@Repository
public interface StudentDao  extends JpaRepository<Student	, Integer>{
	
	
	@Query("select s.firstName from Student s where s.rollNo=:id")
	public String getStudentFirstName(int id);
	
	
	@Transactional
	@Modifying
	@Query("update Student set firstName=:fname where rollNo=:roll")
	public void updateStudent(int roll,String fname);

}
