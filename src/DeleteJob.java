import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Job;

public class DeleteJob {

	public static void main(String[] args) throws Exception {
     	Configuration c  = new Configuration();
		c.configure(); // loads hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Job j = (Job) s.get(Job.class, "hib_prog");
		if (j != null)
    	 	s.delete(j);
		else
			System.out.println("Sorry! Job not found!");
		// j is Removed 
     	s.getTransaction().commit();  // send UPDATE to database 
		s.close();
		sf.close();
	}

}
