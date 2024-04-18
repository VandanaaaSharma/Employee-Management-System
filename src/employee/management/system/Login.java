package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
    Login() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 600, 300);
        add(image1);
        
        JLabel username = new JLabel("Username");
        username.setForeground(Color.WHITE);
        username.setBounds(40, 20, 100, 30);
        image1.add(username);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        image1.add(tfusername);
        
        JLabel password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setBounds(40, 70, 100, 30);
        image1.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        image1.add(tfpassword);
        
        JButton clickhere = new JButton("LOGIN");
        clickhere.setBounds(150, 140, 150, 30);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image1.add(clickhere);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            conn c = new conn();
            String query = "select * from Login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Homepage();
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}