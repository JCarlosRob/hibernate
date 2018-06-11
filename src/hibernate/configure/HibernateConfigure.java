package hibernate.configure;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.Student;

public class HibernateConfigure {
	/*
	private static HibernateConfigure hibernateConfigure = null;
	
	private HibernateConfigure() {
		
	}
	
	public static HibernateConfigure getHibernateConfigurre() {
		
		if (hibernateConfigure == null) {
			
			hibernateConfigure = new HibernateConfigure();
			
		}
		
		return hibernateConfigure;
		
	}
	
	*/
	private Configuration getConfiguration() {
		
		Configuration config = new Configuration();
		
		config.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class);

		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate?useSSL=false");
		config.setProperty("hibernate.connection.username","root");
		config.setProperty("hibernate.connection.password", "root");
		config.setProperty("hibernate.connection.pool_size", "1");
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		config.setProperty("hibernate.show_sql", "true");
		config.setProperty("hibernate.current_session_context_class", "thread");
		
		
		return config;
		
	}
	
	public SessionFactory sessionFactory () {
		
		SessionFactory sessionFactory = getConfiguration()
										.buildSessionFactory();
			
		return sessionFactory;
		
	}
	
}
