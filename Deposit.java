package bankms;

import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField b1;
    JButton deposit;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atmm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 780, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter ammount you want to deposit:");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(160,350,400,30);
        text.setForeground(Color.white);
        image.add(text);
        
         b1=new JTextField();
        b1.setBounds(190,390,250,25);
        image.add(b1);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(350,440,90,25);
        deposit.setBackground(Color.green);
        deposit.addActionListener(this);
        add(deposit);
                
        setSize(900,900);
        setLocation(300,20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
            String amt=b1.getText();
            Date date= new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter some ammount");
            }
            else{
                try {
                Conn cn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','deposit','"+amt+"')";
                cn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Money successfully deposited");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                catch (Exception e ){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
}
