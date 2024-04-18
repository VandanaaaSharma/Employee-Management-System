
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Demo extends JFrame implements ActionListener{
    Demo() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1100,60);
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.WHITE);
        add(heading);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/font.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100, 1050,500);
                add(image);
                JButton clickhere = new JButton("CONTINUE");
                clickhere.setBounds(400,400,200,70);
                clickhere.setBackground(Color.BLACK);
                clickhere.setForeground(Color.WHITE);
                clickhere.setFont(new Font("serif", Font.PLAIN, 30));
                clickhere.addActionListener(this);
                image.add(clickhere);
                
    setSize(1170,650);
    setLocation(170, 50);
    setVisible(true);
}
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Login();
   }
    public static void main(String args[]){
        new Demo();
        System.out.println("Hello world");
    }
    
}
