package manytomany;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

    public static void main(String[] args) {
        Configuration c = new Configuration().configure();
        c.addResource("manytomany/manytomany.hbm.xml");
        SessionFactory sf = c.buildSessionFactory();
        Session session = sf.openSession();

        Employee e = new Employee();
        e.setName("Gavin");

        Employee e2 = new Employee();
        e2.setName("Greg");

        Project p = new Project();
        p.setTitle("Online Attendance");

        e.getProjects().add(p);
        e2.getProjects().add(p);

        p.getEmployees().add(e);
        p.getEmployees().add(e2);

        session.beginTransaction();
        session.save(e);
        session.save(e2);
        session.getTransaction().commit();

        // list all employees with project titles
        List elst = session.createQuery("from Employee").list();

        for(Object o : elst) {
             e = (Employee) o;
             System.out.println(e.getName());
             for ( Project proj : e.getProjects()) {
                  System.out.println("\t" + proj.getTitle());
             }
        }

        session.close();
        sf.close();
    }

}
