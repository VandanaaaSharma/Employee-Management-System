
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class View extends JFrame implements ActionListener{
    JTable table;
    Choice coempid;
    JButton Search, back, print,update;
    View(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel search = new JLabel("Search");
        search.setBounds(20,20,150,20);
        add(search);
        coempid = new Choice();
        coempid.setBounds(180,20,150,20);
        add(coempid);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from emp");            
            while(rs.next()){
                coempid.add(rs.getString("empid"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from emp");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        Search = new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
    setLocation(300, 100);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if (ae.getSource() == Search){
           String query = "select * from emp where empid = '"+coempid.getSelectedItem()+"'";
           try{
               conn c = new conn();
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               e.printStackTrace();
           }
       }else if(ae.getSource()==print){
           try{
              table.print(); 
           }catch(Exception e){
               e.printStackTrace();
           }
       } else if(ae.getSource()==update){
           setVisible(false);
           new Update(coempid.getSelectedItem());
       }else{
           setVisible(false);
           new Homepage();
       }
   }
    public static void main(String[] args){
        new View();
    }
    
}
