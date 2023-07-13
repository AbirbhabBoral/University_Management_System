package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
    Choice cempID;
    JTable table;
    JButton search, print, cancel;
    
    TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cempID = new Choice();
        cempID.setBounds(180,20,150,20);
        add(cempID);
        
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            while(rs.next()){
                cempID.add(rs.getString("empID"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from teacherleave where empID = '"+cempID.getSelectedItem()+"'";
            try{
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == print){
            try{
                table.print();
            } catch(Exception e){
                e.printStackTrace();
            }
        }  else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new TeacherLeaveDetails();
    }
}
