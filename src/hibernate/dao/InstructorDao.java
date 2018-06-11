package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.configure.HibernateConfigure;
import hibernate.entity.Course;
import hibernate.entity.Instructor;

public class InstructorDao {

	public String getName(int id) {
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		String name = null;
		
		try {
		
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, id);
		
		name = instructor.getName();
		
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
	
	public List<Course> getCourses(int idInstructor){
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		List<Course> courses = null;
		
		try {
		
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, idInstructor);
		
		courses = instructor.getCourses();
		
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
