package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login,cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login (){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(40,20,100,20);
        add(lbusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(40,70,100,20);
        add(lbpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            try{
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                  setVisible(false);
                  new Project();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                c.s.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
