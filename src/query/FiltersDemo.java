package query;

import java.util.List;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class FiltersDemo {
    public static void main(String[] args) throws Exception  {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/filter.hbm.xml");
      Session session = c.buildSessionFactory().openSession();

      Filter costlybooks = session.enableFilter("costlybooks");
      costlybooks.setParameter("cutoffPrice", new Integer(400));
      List result = session.createQuery("from Title").list();

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
