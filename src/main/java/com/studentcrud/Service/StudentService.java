package com.studentcrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentcrud.EntityPackages.Student;
import com.studentcrud.Repository.StudentRepository;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;
    
	public StudentService() {
		
	}
  

	@Transactional
	public List<Student> getAll() {
		
		return studentRepo.getAll();
	}


	@Transactional
	public Student getbyId(int id) {
	
		return studentRepo.getbyId(id);
	}

	
	@Transactional
	public void delete(int id) {
		studentRepo.delete(id);
		
	}


	@Transactional
	public void add(Student st) {
		studentRepo.add(st);
		
	}

}
