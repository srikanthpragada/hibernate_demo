import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Job;

public class AddJob {

	public static void main(String[] args) throws Exception {
     	Configuration c  = new Configuration();
		c.configure(); // loads hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Job j = new Job();
		j.setId("hib_prog");
		j.setTitle("Hibernate Programmer");
		
		s.beginTransaction();
		
		s.save(j);  // persist object 
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}

}
