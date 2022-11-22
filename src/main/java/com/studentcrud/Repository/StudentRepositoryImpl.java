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
   private EntityManager em;
	public StudentRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Student> getAll() {
		
		Query q = em.createQuery("from Student",Student.class);
		List<Student> students = q.getResultList();
		return students;
	}

	@Override
	public Student getbyId(int id) {
		
		Student s = em.find(Student.class,id);
		return s;
	}

	@Override
	public void delete(int Sid) {
		Query q = em.createQuery("delete from Student where id =: theid");
		q.setParameter("theid",Sid);
		q.executeUpdate();
		
	}

	@Override
	public void add(Student st) {
	em.merge(st);
		
	}

}
