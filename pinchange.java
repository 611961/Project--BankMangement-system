package bankms;

import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
import java.util.*;
public class Pinchange extends JFrame implements ActionListener{
    
    JButton b3;
    JPasswordField b1,b2;
    String pinnumber;
    
     Pinchange(String pinnumber){
         this.pinnumber=pinnumber;
         setLayout(null);
         
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("logos/atmm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900,780,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
         JLabel image= new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
        setSize(900,900);
        setLocation(300,20);
        setVisible(true);
        
        JLabel text= new JLabel("Change Your Pin:");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(160,350,400,30);
        text.setForeground(Color.white);
        image.add(text);
        
        JLabel text2= new JLabel("Enter New Pin");
        text2.setFont(new Font("System",Font.ITALIC,14));
        text2.setBounds(190,390,400,30);
        text2.setForeground(Color.white);
        image.add(text2);
        
       b1= new JPasswordField();
        b1.setBounds(350,396,100,20);
        image.add(b1);
        
        JLabel text3= new JLabel("Renter New Pin");
        text3.setFont(new Font("System",Font.ITALIC,14));
        text3.setBounds(190,430,400,30);
        text3.setForeground(Color.white);
        image.add(text3);
        
         b2= new JPasswordField();
        b2.setBounds(350,436,100,20);
        image.add(b2);
        
         b3 = new JButton("Done");
        b3.setBounds(380,480,80,20);
        b3.setBackground(Color.green);
        image.add(b3);
        b3.addActionListener(this);
     }
     
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b3){
             try {
             String npin= b1.getText();
             String rpin= b2.getText();
             if(!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null,"Pins doesn't match");
                 
             }
             else if(npin.equals("") || npin.length()<6){
                 JOptionPane.showMessageDialog(null,"Please enter pin of atleast 6 characters");
             }
             else if(npin.equals(rpin)){
                 Conn con = new Conn();
                 String query1 = "update bank set pin ='"+rpin+"' where pin ='"+pinnumber+"' ";
                 String query2 = "update loginatm set pin ='"+rpin+"' where pin ='"+pinnumber+"' ";
                 String query3 = "update signupt set pin ='"+rpin+"' where pin ='"+pinnumber+"' ";
                 JOptionPane.showMessageDialog(null,"Pin Changed Succesfully");
                 setVisible(false);
                 
                 new Transaction(rpin).setVisible(true);
             }
         }
             catch(Exception e){
                 System.out.println(e);
                 
                 }
            }
     }
     public static void main(String args[]){
         new Pinchange("");
     }
}
