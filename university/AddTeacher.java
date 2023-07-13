
package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfX, tfXII, tfaadhar;
    JLabel labelempID;
    JDateChooser dob;
    JComboBox course, branch;
    JButton submit, cancel;
    Random rn = new Random();
    long first4 = Math.abs((rn.nextLong()%9000L) + 1000L);
    
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,30));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,30));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel lblempId = new JLabel("Employee ID");
        lblempId.setBounds(50,200,200,30);
        lblempId.setFont(new Font("serif",Font.BOLD,30));
        add(lblempId);
        
        labelempID = new JLabel("105"+first4);
        labelempID.setBounds(250,200,200,30);
        labelempID.setFont(new Font("serif",Font.BOLD,30));
        add(labelempID);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,30));
        add(lbldob);
        
        dob = new JDateChooser();
        dob.setBounds(600,200,150,30);
        add(dob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,30));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,30));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,30));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel lblX = new JLabel("Class X (in %)");
        lblX.setBounds(400,300,200,30);
        lblX.setFont(new Font("serif",Font.BOLD,30));
        add(lblX);
        
        tfX = new JTextField();
        tfX.setBounds(600,300,150,30);
        add(tfX);
        
        JLabel lblXII = new JLabel("Class XII(in %)");
        lblXII.setBounds(50,350,250,30);
        lblXII.setFont(new Font("serif",Font.BOLD,30));
        add(lblXII);
        
        tfXII = new JTextField();
        tfXII.setBounds(270,350,75,30);
        add(tfXII);
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,30));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel lblquali = new JLabel("Qualification");
        lblquali.setBounds(50,400,200,30);
        lblquali.setFont(new Font("serif",Font.BOLD,30));
        add(lblquali);
        
        String courses[] = {"B.Tech", "BBA", "BCA", "B.Sc", "M.Sc", "M.Tech","MBA","MCA","B.Com","B.A","M.Com",
                            "M.A"};
        course = new JComboBox(courses);
        course.setBounds(250,400,100,30);
        course.setBackground(Color.WHITE);
        add(course);
        
        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(400,400,200,30);
        lbldept.setFont(new Font("serif",Font.BOLD,30));
        add(lbldept);
        
        String branches[] = {"Computer Science","Electronics and Communication","Electronics and"
                + " Instrumentation","Information Technology","Mechanical","Electrical","Civil"};
        branch = new JComboBox(branches);
        branch.setBounds(600,400,200,30);
        branch.setBackground(Color.WHITE);
        add(branch);
        
        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempID.getText();
            String date = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfX.getText();
            String xii = tfXII.getText();
            String aadhar = tfaadhar.getText();
            String qual = (String)course.getSelectedItem();
            String dept = (String)branch.getSelectedItem();
            
            try{
                String query = "insert into teacher values('"+name+"', '"+fname+"','"+empId+"','"+date+"','"
                        +address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+qual+"','"+dept+"')";
                Connect con = new Connect();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully!");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddTeacher();
    }
}
