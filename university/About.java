package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    
    About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,0,300,200);
        add(img);
        
        JLabel name = new JLabel("Developed By: Abirbhab Boral");
        name.setBounds(70,220,500,130);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);
        
        JLabel college = new JLabel("College: Heritage Institute of Technology");
        college.setBounds(70,270,500,130);
        college.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(college);
        
        JLabel dept = new JLabel("Department: AEIE");
        dept.setBounds(70,320,500,130);
        dept.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(dept);
        
        setVisible(true);
    }
    
    public static void main(String args[]){
        new About();
    }
}
