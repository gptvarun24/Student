package com.studentcrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentcrud.EntityPackages.Student;
import com.studentcrud.Repository.StudentRepository;
import com.studentcrud.exception.StudentException;
@Service
public class StudentService {
	
    @Autowired
    private StudentRepository studentRepo;
    
	public StudentService() {
		
	}
  

	@Transactional
	public List<Student> getAll() {
		
		List<Student> studentList =  studentRepo.getAll();
		return studentList;
	}


	@Transactional
	public Student getbyId(int id) {
	
		Student student =  studentRepo.getbyId(id);
		if(student==null)
		{
			throw new StudentException("Student not found in Database");
		}
		return student;
	}

	
	@Transactional
	public String delete(int id) {
		 Student student = getbyId(id);
		 if(student==null)
		  {
			  throw new StudentException("Student not found in Database");
		  }
		 studentRepo.delete(id);
		 return "Student deleted successfully with id : " + id;
	}


	@Transactional
	public String add(Student student) {
		
		studentRepo.add(student);
		return "Student added successfully";
	}
	
	@Transactional
	public String update(Student student) {
		Student dbStudent = getbyId(student.getId());
		if(dbStudent==null)
		  {
			  throw new StudentException("Student not found in Database");
		  }
		studentRepo.add(student);
		return "Student updated successfully";
	}

}
