import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Job;

public class UpdateJobTitle {

	public static void main(String[] args) throws Exception {
     	Configuration c  = new Configuration();
		c.configure(); // loads hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Job j = (Job) s.get(Job.class, "hib_prog");
		
		// j is Persistent
		j.setTitle("Hibernate 3 programmer");
     	s.getTransaction().commit();  // send UPDATE to database 
		s.close();
		
		// j is detached 
		j.setTitle("Hibernate 3 programmer");
		System.out.println(j.getTitle());
		sf.close();
	}

}
