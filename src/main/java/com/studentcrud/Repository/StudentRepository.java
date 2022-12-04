package com.studentcrud.Repository;

import java.util.List;


import com.studentcrud.EntityPackages.Student;

public interface StudentRepository{

	public List<Student> getAll();

	public Student getbyId(int id);

	public void delete(int id);

	public void add(Student st);

}
