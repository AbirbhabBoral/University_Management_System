
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelRoll;
    JButton submit, cancel;
    Choice croll;
    
    UpdateStudent(){
        setSize(900,650);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);
        
        croll = new Choice();
        croll.setBounds(250,100,200,20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);
        
        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(50,200,200,30);
        lblroll.setFont(new Font("serif",Font.BOLD,20));
        add(lblroll);
        
        labelRoll = new JLabel();
        labelRoll.setBounds(250,200,200,30);
        labelRoll.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelRoll);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel lblX = new JLabel("Class X (in %)");
        lblX.setBounds(400,300,200,30);
        lblX.setFont(new Font("serif",Font.BOLD,20));
        add(lblX);
        
        JLabel labelX = new JLabel();
        labelX.setBounds(600,300,150,30);
        labelX.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelX);
        
        JLabel lblXII = new JLabel("Class XII(in %)");
        lblXII.setBounds(50,350,250,30);
        lblXII.setFont(new Font("serif",Font.BOLD,20));
        add(lblXII);
        
        JLabel labelXII = new JLabel();
        labelXII.setBounds(270,350,75,30);
        labelXII.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelXII);
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
                       
        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,200,30);
        add(tfbranch);
        
        try{
            Connect c = new Connect();
            String query = "select * from student where rollno = '"+croll.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelRoll.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("dob"));
                labelX.setText(rs.getString("class_x"));
                labelXII.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
                }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        croll.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    Connect c = new Connect();
                    String query = "select * from student where rollno = '"+croll.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labelRoll.setText(rs.getString("rollno"));
                        labeldob.setText(rs.getString("dob"));
                        labelX.setText(rs.getString("class_x"));
                        labelXII.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                        }
                    } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
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
            String roll = labelRoll.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String crse = (String)tfcourse.getText();
            String brnch = (String)tfbranch.getText();
            
            try{
                String query = "update student set address='"+address+"',phone = '"+phone+"', email = '"+email+""
                        + "',course = '"+crse+"', branch = '"+brnch+"' where rollno = '"+roll+"'";
                Connect con = new Connect();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully!");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateStudent();
    }
}
