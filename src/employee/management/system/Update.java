

package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Update extends JFrame implements ActionListener{
    JTextField tfeducation,  tfphone, tfemail, tfsalary, tfaddress,tfdesignation;
    JLabel lblempid;
    JButton add, back;
    String empid;
    Update(String empid){
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Update Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN-SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        add(name);
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150,30);
        add(lblname);
        
        JLabel fathername = new JLabel("Father's Name");
        fathername.setBounds(400, 150, 150, 30);
        fathername.setFont(new Font("serif", Font.PLAIN, 20));
        add(fathername);
        JLabel lblfathername = new JLabel();
        lblfathername.setBounds(600, 150, 150,30);
        add(lblfathername);
        
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("serif", Font.PLAIN, 20));
        add(salary);
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150,30);
        add(tfsalary);
        
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.PLAIN, 20));
        add(address);
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150,30);
        add(tfaddress);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(phone);
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150,30);
        add(tfphone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        add(tfemail);
        
        JLabel education = new JLabel("Higher Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("serif", Font.PLAIN, 20));
        add(education);
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600, 300, 150,30);
        add(tfeducation);
        
        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50, 350, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
        lblempid = new JLabel();
        lblempid.setBounds(200, 350, 150,30);
        add(lblempid);
        
        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 350, 150, 30);
        designation.setFont(new Font("serif", Font.PLAIN, 20));
        add(designation);
        tfdesignation = new JTextField();
        tfdesignation.setBounds(600, 350, 150,30);
        add(tfdesignation);
        
        try{
            conn c = new conn();
            String query = "select * from emp where empid = '"+empid+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                lblfathername.setText(rs.getString("fathername"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblempid.setText(rs.getString("empid"));
                tfdesignation.setText(rs.getString("designation"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == add){
             String salary = tfsalary.getText();
             String address = tfaddress.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();
             String education = tfeducation.getText();
             String designation = tfdesignation.getText();
             try{
                 conn c = new conn();
                 String query = "update emp set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empid = '"+empid+"'";                
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "update succesfully");
                 setVisible(false);
                 new Homepage();
             } catch (Exception e){
                 e.printStackTrace();
             }
             
         }else{
             setVisible(false);
             new Homepage();
         }
     }
    public static void main(String[] args){
        new Update("");
    }
    
}

