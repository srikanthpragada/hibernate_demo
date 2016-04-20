package query;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class QueryFrame extends JFrame implements ActionListener {
    JTextArea query;
    JButton btnExecute;
    JTextArea result;
    Session session  =null;

    public QueryFrame() {
        super("HQL Frame");
        query = new JTextArea();
        query.setRows(3);
        query.setColumns(50);
        btnExecute = new JButton("Execute");
        btnExecute.addActionListener(this);
        result = new JTextArea();
        result.setEditable(false);

        JPanel tp = new JPanel();
        tp.setLayout( new BorderLayout());

        tp.add( new JScrollPane(query, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        tp.add( btnExecute, BorderLayout.PAGE_END);

        add(tp, BorderLayout.PAGE_START);
        add(new JScrollPane(result, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED) );


        Configuration c = new Configuration();
        c.configure("query/hibernate.cfg.xml");
        c.addResource("query/catalog.hbm.xml");
        session = c.buildSessionFactory().openSession();

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {

        QueryFrame q = new QueryFrame();
        q.setSize(800,300);
        q.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        StringBuffer output = new StringBuffer();
        try {
           List results = session.createQuery( query.getText()).list();
           for( Object obj : results) {
             if ( obj instanceof Object[]) {
                 for ( Object o : (Object[]) obj) {
                      output.append( o == null? "null" : o.toString() + "  ");
                 }
                 output.append("\r\n");
             }
             else
               output.append(obj.toString() + "\r\n");
           } // end of for
           result.setText(output.toString());
          }
          catch(Exception ex){
              result.setText("Error-->" + ex.getMessage());
          }
    }
}
