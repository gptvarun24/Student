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
	public ResponseEntity<Student> getbyId(@PathVariable int studentid) throws Exception
	{  
		Student student = service.getbyId(studentid);
		if(student==null)
		{
			throw new Exception("Student not found in Database");
		}
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable int id) throws Exception
	{   Student student = service.getbyId(id);
	  if(student==null)
	  {
		  throw new Exception("Student not found in Database");
	  }
		service.delete(id);
	}
	
	@PostMapping("/students")
	public void add(@RequestBody Student student)
	{   student.setId(0);
		service.add(student);
	}
	
	@PutMapping("/students")
	public void update(@RequestBody Student st)
	{
		service.add(st);
	}

}
