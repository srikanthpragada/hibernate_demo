package query;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 

public class BulkUpdateDemo {
    public static void main(String[] args) {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/catalog.hbm.xml");
      Session session = c.buildSessionFactory().openSession();
      
      Transaction tx = session.beginTransaction();

      Query q = session.createQuery("update Title set price = price - 50 where price > 500");
      int cnt = q.executeUpdate();
      System.out.println("No. of rows  updated :  " + cnt);

      tx.commit();
      session.close();
    } // main
 } // class
