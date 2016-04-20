package query;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public class QueryByExample {
    public static void main(String[] args) {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      c.addResource("query/catalog.hbm.xml");

      Session session = c.buildSessionFactory().openSession();
      Subject s = new Subject();
      s.setSubname("java");
      

      Example subjectex = Example.create(s).ignoreCase()
              .enableLike(MatchMode.ANYWHERE);

      List result = session.createCriteria(Subject.class).add(subjectex).list();
      printList(result);

      Title t= new Title();
      t.setTitle("comp");


      Example titleex = Example.create(t).ignoreCase()
              .enableLike(MatchMode.ANYWHERE)
              .excludeProperty("price");

      result = session.createCriteria(Title.class).add(titleex).list();
      printList(result);


     

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
