package inh;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListCricketers {
    public static void main(String[] args) {
        Configuration c = new Configuration();
        c.addResource("inh/tableperclasshierarchy.hbm.xml");
        //c.addResource("inh/tablepersubclass.hbm.xml");
        // c.addResource("inh/tableperconcreteclass.hbm.xml");
        SessionFactory sf = c.configure().buildSessionFactory();
        Session session = sf.openSession();
       
        List<Cricketer> list =(List<Cricketer>) session.createQuery("from Cricketer").list();
        
        for(Cricketer crkter : list) {
        	System.out.println(crkter);
        }
        session.close();
        sf.close();
    }
}
