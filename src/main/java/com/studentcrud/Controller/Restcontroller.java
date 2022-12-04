package com.studentcrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentcrud.EntityPackages.Student;
import com.studentcrud.Service.StudentService;


@RestController
public class Restcontroller {
	
    @Autowired
    private StudentService service;
    
    
	public Restcontroller() {
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAll()
	{   
		List<Student> studentList = service.getAll();
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentid}")
	public ResponseEntity<Student> getbyId(@PathVariable int studentid) 
	{  
		Student student = service.getbyId(studentid);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) 
	{  
	    String response = service.delete(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<String> add(@RequestBody Student student)
	{   
		String response = service.add(student);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<String> update(@RequestBody Student student)
	{
		String response = service.update(student);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
