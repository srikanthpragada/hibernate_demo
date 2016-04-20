package query;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CriteriaDemo {
    public static void main(String[] args) {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/catalog.hbm.xml");
      Session session = c.buildSessionFactory().openSession();
      Criteria ct = session.createCriteria(Title.class)
                    .add( Restrictions.between("price",300,500))
                    .addOrder(Order.desc("price"));
      
      printList(ct.list());
     
      ct = session.createCriteria(Title.class)
             .add( Restrictions.gt("price",400))
             .createCriteria("subject")
             .add( Restrictions.eq("subcode","java"));
      printList(ct.list());
    } // main
    
    public static void printList(List result){
           System.out.println("Query Result");
           System.out.println("==================================================");
           for( Object obj : result) {
             if ( obj instanceof Object[]) {
                 for ( Object o : (Object[]) obj) {
                      System.out.print(o.toString() + "  ");
                 }
                 System.out.println();
             }
             else
              System.out.println( obj.toString());            
          } // for

    }
   } // class
