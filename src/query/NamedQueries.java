package query;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class NamedQueries {
    public static void main(String[] args) throws Exception  {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/namedqueries.hbm.xml");
      Session session = c.buildSessionFactory().openSession();

      List result = session.getNamedQuery("costlytitles").list();
      printQueryResult(result);

      // Native named query
      result = session.getNamedQuery("discounts").list();
      printQueryResult(result);

   }

   public static void printQueryResult(List result) {
     System.out.println("Result");
     System.out.println("============");
     for( Object obj : result) {
             if ( obj instanceof Object[]) {
                 for ( Object o : (Object[]) obj) {
                      System.out.print(o.toString() + "  ");
                 }
                 System.out.println();
             }
             else
              System.out.println( obj.toString());
         
      }
    }
}
