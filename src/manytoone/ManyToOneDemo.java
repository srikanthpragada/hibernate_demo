package manytoone;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 

public class ManyToOneDemo {

    public static void main(String[] args) {
        Configuration c = new Configuration().configure();
        c.addResource("manytoone/manytoone.hbm.xml");
        SessionFactory sf = c.buildSessionFactory();
        Session session = sf.openSession();

        Employee e = new Employee();
        e.setName("Gavin");

        Employee e2 = new Employee();
        e2.setName("Johnson");

        Department d = new Department();
        d.setName("SALES");
        
        d.getEmployees().add(e);
        d.getEmployees().add(e2);

        e.setDepartment(d);
        e2.setDepartment(d);

        session.beginTransaction();
        session.save(e);
        session.save(e2);
        session.getTransaction().commit();

        // retrieve Employees
        List elst = session.createQuery("from Employee").list();

        for(Object o : elst) {
             e = (Employee) o;
             System.out.printf("%s %s\n", e.getName(), e.getDepartment().getName());
        }
        
        // list all departments with employee names 
        List dlst = session.createQuery("from Department").list();

        for(Object o : dlst) {
             d = (Department) o;
             System.out.println(d.getName());
             for ( Employee emp : d.getEmployees()) {
                  System.out.println("\t" + emp.getName());
             }
        }



        session.close();
        sf.close();
    }

}

 