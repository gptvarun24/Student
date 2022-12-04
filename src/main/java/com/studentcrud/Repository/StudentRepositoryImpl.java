package com.studentcrud.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentcrud.EntityPackages.Student;
@Repository
public class StudentRepositoryImpl implements StudentRepository {
   @Autowired
   private EntityManager entityManager;
	public StudentRepositoryImpl() {
	
	}

	@Override
	public List<Student> getAll() {
		
		Query query = entityManager.createQuery("from Student",Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public Student getbyId(int id) {
		
		Student student = entityManager.find(Student.class,id);
		return student;
	}

	@Override
	public void delete(int studentId) {
		Query q = entityManager.createQuery("delete from Student where id =: id");
		q.setParameter("id",studentId);
		q.executeUpdate();
		
	}

	@Override
	public void add(Student student) {
		entityManager.merge(student);
		
	}

}
