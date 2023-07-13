package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project(){
        setSize(1580,870);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1580, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        
        JMenuBar mb = new JMenuBar();
        
        //New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        
        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyLeave = new JMenuItem("Apply Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        JMenuItem studentLeave = new JMenuItem("Apply Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);
        
        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        //Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examdetails = new JMenuItem("Examination Results");
        examdetails.setBackground(Color.WHITE);
        examdetails.addActionListener(this);
        exam.add(examdetails);
        
        JMenuItem enterMarks = new JMenuItem("Update Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        //Update Info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.setBackground(Color.WHITE);
        updateFaculty.addActionListener(this);
        updateInfo.add(updateFaculty);
        
        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.setBackground(Color.WHITE);
        updateStudent.addActionListener(this);
        updateInfo.add(updateStudent);
        
        //Fees
        JMenu fees = new JMenu("Fee Details");
        fees.setForeground(Color.BLUE);
        mb.add(fees);
        
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fees.add(feeStructure);
        
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fees.add(feeForm);
        
        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About Project");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
                
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        } else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch(Exception e) {
                
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch(Exception e) {
                
            }
        } else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        } else if(msg.equals("New Student Information")){
            new AddStudent();
        } else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        } else if(msg.equals("View Student Details")){
            new StudentDetails();
        } else if(msg.equals("Apply Faculty Leave")){
            new TeacherLeave();
        } else if(msg.equals("Apply Student Leave")){
            new StudentLeave();
        } else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        } else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        } else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        } else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        } else if(msg.equals("Update Marks")){
            new EnterMarks();
        } else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        } else if(msg.equals("Fee Structure")){
            new FeeStructure();
        } else if(msg.equals("About Project")){
            new About();
        } else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }
    }
    public static void main(String[] args){
        new Project();
    }
}
