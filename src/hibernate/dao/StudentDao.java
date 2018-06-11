package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.configure.HibernateConfigure;
import hibernate.entity.Course;
import hibernate.entity.Student;

public class StudentDao {

	public String getName(int id) {
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		String name = null;
		
		try {
		
		session.beginTransaction();
		
		Student student = session.get(Student.class, id);
		
		name = student.getName();
		
		}
		
		catch(Exception e){
			
			System.out.println(e);
			
		}
		
		finally {
			
			session.close();
			sessionFactory.close();
			
		}
		
		return name;
		
	}
	
	public List<Course> getCourses(int idStudent) {
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		List<Course> courses = null;
		
		try {
		
		session.beginTransaction();
		
		Student student = session.get(Student.class, idStudent);
		
		courses = student.getCourses();
		
		}
		
		catch(Exception e){
			
			System.out.println(e);
			
		}
		
		finally {
			
			session.close();
			sessionFactory.close();
			
		}
		
		return courses;
		
	}
	
}
