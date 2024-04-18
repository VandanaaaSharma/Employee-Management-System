
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class Add extends JFrame implements ActionListener{
    Random ran = new Random();
    int number = ran.nextInt(9999);
    JTextField tfname, tffathername, tfphone, tfemail, tfsalary, tfaddress,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add, back;
    Add(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 900, 700);
        add(image1);
        JLabel heading = new JLabel("Add Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN-SERIF", Font.BOLD, 25));
        image1.add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(name);
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150,30);
        image1.add(tfname);
        
        JLabel fathername = new JLabel("Father's Name");
        fathername.setBounds(400, 150, 150, 30);
        fathername.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(fathername);
        tffathername = new JTextField();
        tffathername.setBounds(600, 150, 150,30);
        image1.add(tffathername);
        
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(dob);
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        image1.add(dcdob);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(salary);
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150,30);
        image1.add(tfsalary);
        
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(address);
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150,30);
        image1.add(tfaddress);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(phone);
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150,30);
        image1.add(tfphone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(email);
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        image1.add(tfemail);
        
        JLabel education = new JLabel("Higher Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(education);
        String courses[] = {"B.tech", "M.tech", "M.tech(integrated)", "BBA", "BCA"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150,30);
        image1.add(cbeducation);
        
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 350, 150, 30);
        empid.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(empid);
        lblempid = new JLabel("" + number);
        lblempid.setBounds(200, 350, 150,30);
        image1.add(lblempid);
        
        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 350, 150, 30);
        designation.setFont(new Font("serif", Font.BOLD, 20));
        image1.add(designation);
        tfdesignation = new JTextField();
        tfdesignation.setBounds(600, 350, 150,30);
        image1.add(tfdesignation);
        
        add = new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image1.add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image1.add(back);
        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == add){
             String name = tfname.getText();
             String fathername = tffathername.getText();
             String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
             String salary = tfsalary.getText();
             String address = tfaddress.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();
             String education = (String) cbeducation.getSelectedItem();
             String designation = tfdesignation.getText();
             String empid = lblempid.getText();
             try{
                 conn c = new conn();
                 String query = "insert into emp values('"+name+"', '"+fathername+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"','"+designation+"', '"+empid+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "succesfully added");
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
        new Add();
    }
    
}
