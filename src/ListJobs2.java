import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;

import entity.Job;

public class ListJobs2 {

	public static void main(String[] args) throws Exception {

		SessionFactory sf;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				                                     .configure().build();
		try {
			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			Session s = sf.openSession();

			Query q = s.createQuery("from Job");
			
			for (Job j : (List<Job>) q.list())
			{
				System.out.println(j.getTitle());
			}
			
			
			
			s.close();
			sf.close();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
