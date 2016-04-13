import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Customer;

public class AddCustomer {

	public static void main(String[] args) throws Exception {
     	Configuration cfg  = new Configuration();
		cfg.configure(); // loads hibernate.cfg.xml
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Customer c = new Customer();
		c.setName("Gavin");
		c.setEmail("gavin@gmail.com");
		
			
		Address a = new Address();
		a.setDno("10");
		a.setStreet("Dwk");
		a.setCity("Vizag");
		a.setPin("530016");
		c.setHome(a);
		
		HashSet<String> phones = new HashSet<>();
		phones.add("9059057000");
		phones.add("2541948");
		c.setPhones(phones);
	
		s.beginTransaction();
		
		s.save(c);  // persist object
	
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}

}
