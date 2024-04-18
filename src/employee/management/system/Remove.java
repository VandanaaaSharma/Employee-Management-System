
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Remove extends JFrame implements ActionListener{
    Choice cempid;
    JButton back, delete;
    Remove(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 50, 100, 30);
        add(empid);
        
        cempid = new Choice();
        cempid.setBounds(200, 50, 150, 30);
        add(cempid);
        
        try{
            conn c = new conn();
            String query = "select * from emp";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 100, 30);
        add(name);
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 150, 100, 30);
        add(phone);
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(50, 200, 100, 30);
        add(email);
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        try{
            conn c = new conn();
            String query = "select * from emp where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));

            }
        } catch(Exception e){
            e.printStackTrace();
        }
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            conn c = new conn();
            String query = "select * from emp where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));

            }
        } catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(200, 300, 100, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0, 600,400);
                add(image);
    setSize(1000,400);
    setLocation(300, 150);
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == delete) {
        try {
            conn c = new conn();
            String query = "DELETE FROM emp WHERE empid = '" + cempid.getSelectedItem() + "'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
            setVisible(false);
            new Homepage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
        new Homepage();
    }
}

    public static void main(String[] args){
        new Remove();
    }
    
}
