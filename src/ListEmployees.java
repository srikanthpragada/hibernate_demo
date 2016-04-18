
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;
import entity.Membership;


public class ListEmployees {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // loads hibernate.cfg.xml
		c.addResource("entity/onetooneud.hbm.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		// employees 
		Query q = s.createQuery("from Employee");

		for (Employee e : (List<Employee>) q.list()) {
			System.out.println( e.getName()  +" , " +  e.getMembership().getType());
		}

		
		System.out.println("Done");
		
		// Memberships

		Query q2 = s.createQuery("from Membership");

		for (Membership m : (List<Membership>) q2.list()) {
			System.out.println( m.getType());
		}

		s.close();
		sf.close();
	}

}
