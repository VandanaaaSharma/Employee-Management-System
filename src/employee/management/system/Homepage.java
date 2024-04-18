package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class Homepage extends JFrame implements ActionListener{
    JButton add, View, update, remove;
    Homepage(){
        
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/color.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 1120,630);
                add(image);
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(80,30,1100,60);
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        ImageIcon smallIcon = new ImageIcon(ClassLoader.getSystemResource("icons/first page.jpg")); 
        Image smallImage = smallIcon.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT); 
        ImageIcon smallImageIcon = new ImageIcon(smallImage);
        JLabel smallImageLabel = new JLabel(smallImageIcon);

        
        int rightMargin = 80; 
        int topMargin = 120; 
        smallImageLabel.setBounds(1120 - rightMargin - smallImage.getWidth(null), topMargin, smallImage.getWidth(null), smallImage.getHeight(null));
        image.add(smallImageLabel);  
       
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        add = new JButton("Add Employee");
        add.setBounds(120,200,200,80);
        add.addActionListener(this);
        image.add(add);
        View = new JButton("view Employee");
        View.setBounds(370,200,200,80);
        View.addActionListener(this);
        image.add(View);
        update = new JButton("Update Employee");
        update.setBounds(120,300,200,80);
        update.addActionListener(this);
        image.add(update);
        remove = new JButton("Remove Employee");
        remove.setBounds(370,300,200,80);
        remove.addActionListener(this);
        image.add(remove);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == add){    
           setVisible(false);
           new Add();
       } else if(ae.getSource() == View){
           setVisible(false);
           new View();
   } else if(ae.getSource() == update){
       setVisible(false);
           new View();
   } else{
       setVisible(false);
       new Remove();
   }
   }
    public static void main(String[] args){
        new Homepage();
    }
    
}
