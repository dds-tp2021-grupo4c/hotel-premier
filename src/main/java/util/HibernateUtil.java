package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static Session session;

/*	public synchronized static Session getSession() {
		if(session == null)
			session = configure().openSession();
		return session;
	}
	
	private static SessionFactory configure() {
		SessionFactory sessionFactory = null;
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception ex){
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return sessionFactory;
	}*/

	public synchronized static Session getSession() {
		if(session == null)
			session = getSessionFactory().openSession();
		return session;
	}
	
	private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure()	//configure settings from hibernate.cfg.xml
					.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception e){
			StandardServiceRegistryBuilder.destroy(registry);
		}

		return sessionFactory;
	}

	public static void closeSession() {
		session.close();
	}
}