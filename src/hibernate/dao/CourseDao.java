package hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.configure.HibernateConfigure;
import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.Student;

public class CourseDao {

	public String getTitle(int id) {
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		String title = null;
		
		try {
		
		session.beginTransaction();
		
		Course course = session.get(Course.class, id);
		
		title = course.getTitle();
		
		}
		
		catch(Exception e){
			
			System.out.println(e);
			
		}
		
		finally {
			
			session.close();
			sessionFactory.close();
			
		}
		
		return title;
		
	}
	
	public Instructor getInstructor(int idCourse) {
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		Course course = null;
		
		try {
		
		session.beginTransaction();
		
		course = session.get(Course.class, idCourse);
		
		}
		
		catch(Exception e){
			
			System.out.println(e);
			
		}
		
		finally {
			
			session.close();
			sessionFactory.close();
			
		}
		
		return course.getInstructor();
		
	}
	
	public List<Course> getCourses () {
		
		SessionFactory sessionFactory = new HibernateConfigure().sessionFactory();		
		Session session = sessionFactory.getCurrentSession();

		List<Course> courses = null;
		
		try {
		
		session.beginTransaction();
		
		Query query = session.createQuery("from Course");
		
		courses = query.getResultList();
		
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
