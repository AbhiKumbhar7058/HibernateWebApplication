package com.dao;

import com.entity.Student;

import java.util.List;

public interface StudentDao {

	int saveStudent(Student student);
	
	int updateStudent(Student student);
	
	void deleteStudent(Student student);
	
	void deleteStudentById(int id);
	
	Student getStudentByid(int id);
	
	List<Student> getAllStudent();
	
	
}
