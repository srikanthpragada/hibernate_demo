package onetoonebd;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddEmployee {

	public static void main(String[] args) throws Exception {
     	Configuration cfg  = new Configuration();
		cfg.configure(); // loads hibernate.cfg.xml
		cfg.addResource("onetoonebd/one_to_one_bd.hbm.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Employee e = new Employee();
		e.setName("Mr. King");
		
		Membership m = new Membership();
		m.setType("Special");
		
		
		e.setMembership(m);
		m.setEmployee(e);
		
		s.save(e);  // persist object
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}

}
