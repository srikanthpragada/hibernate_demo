package inh;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CricketersManager {
    public static void main(String[] args) {
        Configuration c = new Configuration();
        c.addResource("inh/tableperclasshierarchy.hbm.xml");
        //c.addResource("inh/tablepersubclass.hbm.xml");
        // c.addResource("inh/tableperconcreteclass.hbm.xml");
        SessionFactory sf = c.configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Batsman bat = new Batsman();
        bat.setCid(1);
        bat.setName("Virat Kohli");
        bat.setCountry("India");
        bat.setNoruns(3100);
        session.save(bat);

        Bowler bow = new Bowler();
        bow.setCid(2);
        bow.setName("Ashwin");
        bow.setCountry("India");
        bow.setNowickets(180);
        session.save(bow);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
