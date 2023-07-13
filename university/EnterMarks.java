
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice croll;
    JComboBox cbsem;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton submit, cancel;
    
    EnterMarks(){
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,40,400,300);
        add(img);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,70,150,20);
        add(lblrollnumber);
        
        croll = new Choice();
        croll.setBounds(200,70,150,20);
        add(croll);
        
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                croll.add(rs.getString("rollno"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50,110,150,20);
        add(lblsemester);
        
        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester",
        "6th Semester", "7th Semester", "8th Semester"};
        cbsem = new JComboBox(semester);
        cbsem.setBounds(200,110,150,20);
        cbsem.setBackground(Color.WHITE);
        add(cbsem);
        
        JLabel lblenterSub = new JLabel("Enter Subject");
        lblenterSub.setBounds(100,150,200,40);
        add(lblenterSub);
        
        JLabel lblenterMarks = new JLabel("Enter Marks");
        lblenterMarks.setBounds(320,150,200,40);
        add(lblenterMarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250,200,200,20);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250,230,200,20);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250,260,200,20);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250,290,200,20);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250,320,200,20);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
           try{
               Connect c = new Connect();
               String query1 = "insert into subject values('"+croll.getSelectedItem()+"', '"+cbsem.getSelectedItem()+
                       "','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"',"
                       + "'"+tfsub5.getText()+"')";
               String query2 = "insert into marks values('"+croll.getSelectedItem()+"', '"+cbsem.getSelectedItem()+
                       "','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"',"
                       + "'"+tfmarks5.getText()+"')";
               
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null,"Marks Inserted Successfully!");
               setVisible(false);
           } catch(Exception e){
               e.printStackTrace();
           }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new EnterMarks();
    }
}
