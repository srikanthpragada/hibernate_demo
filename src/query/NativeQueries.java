package query;


import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import static org.hibernate.type.StandardBasicTypes.INTEGER;
import static org.hibernate.type.StandardBasicTypes.STRING;


public class NativeQueries {
    public static void main(String[] args) throws Exception  {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/catalog.hbm.xml");
      Session session = c.buildSessionFactory().openSession();

      List result = session.createSQLQuery("select * from subjects").list();
      printQueryResult(result);

      result = session.createSQLQuery("select * from subjects")
    		      .addEntity(Subject.class).list();
      printQueryResult(result);

      result = session.createSQLQuery("select titleid, title from titles").
               addScalar("TITLEID", INTEGER).
               addScalar("TITLE",STRING).list();

      printQueryResult(result);

      Query qry = session.createSQLQuery("select * from titles where title like ?");
      qry.setString(0,"Hi%");

      result = qry.list();
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
