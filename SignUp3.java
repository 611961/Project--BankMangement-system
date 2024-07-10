package bankms;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Signupt extends JFrame implements ActionListener {
     
    String formno;
     JRadioButton b1,b2,b3;
     JCheckBox b4,b5,b6,b7,b8;
     JButton next,cancel;
     
        Signupt(String formno){
        this.formno=formno;
        
        setLayout(null);
        
        setSize(700,600);
        setLocation(410,120);
        setTitle("Form-3");
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
         JLabel topp=new JLabel("Detalils form:3/3");
        topp.setFont(new Font("Raleway",Font.BOLD,25));
        topp.setBounds(270,20,600,30);
        add(topp);
        
        JLabel acnt=new JLabel("Account Type:");
        acnt.setBounds(100,80,150,50);
        acnt.setFont(new Font("Raleway",Font.BOLD,16));
        add(acnt);
        
         
         b1=new JRadioButton("Current account");
        b1.setBounds(120,130,150,30);
         b1.setBackground(Color.white);
        b1.setFont(new Font("Raleway",Font.BOLD,12));
        add(b1);
         
        b2=new JRadioButton("Savig Account");
        b2.setBounds(320,130,150,30);
        b2.setBackground(Color.white);
        b2.setFont(new Font("Raleway",Font.BOLD,12));
        add(b2);
         
        b3=new JRadioButton("Deposit Account");
        b3.setBounds(120,160,150,30);
         b3.setBackground(Color.white);
        b3.setFont(new Font("Raleway",Font.BOLD,12));
        add(b3);
        
        JLabel nmbr=new JLabel("Card Number:");
        nmbr.setFont(new Font("Raleway",Font.BOLD,16));
        nmbr.setBounds(100,200,200,30);
        add(nmbr);
        
        JLabel xxx=new JLabel("XXXX-XXXX-XXXX-"+formno);
        xxx.setFont(new Font("Raleway",Font.BOLD,14));
        xxx.setBounds(300,200,500,30);
        add(xxx);
        
        JLabel nmbrdgt=new JLabel("(Your 16 digit Number)");
        nmbrdgt.setFont(new Font("Raleway",Font.BOLD,10));
        nmbrdgt.setBounds(100,215,200,30);
        add(nmbrdgt);
        
        JLabel pswrd=new JLabel("Password:");
        pswrd.setFont(new Font("Raleway",Font.BOLD,16));
        pswrd.setBounds(100,245,200,30);
        add(pswrd);
        
        JLabel xx=new JLabel("XXXX");
        xx.setFont(new Font("Raleway",Font.BOLD,14));
        xx.setBounds(300,245,100,30);
        add(xx);
        
         JLabel minipswrd=new JLabel("(Your 4 digit password)");
        minipswrd.setFont(new Font("Raleway",Font.BOLD,10));
        minipswrd.setBounds(100,260,200,30);
        add(minipswrd);
         
        JLabel services=new JLabel("Services required:");
        services.setFont(new Font("Raleway",Font.BOLD,16));
        services.setBounds(100,290,200,30);
        add(services);
        
         b4= new JCheckBox("ATM card");
        b4.setFont(new Font("Raleway",Font.BOLD,12));
        b4.setBounds(120,315,200,30);
        b4.setBackground(Color.white);
        add(b4);
        
         b5= new JCheckBox("Online Banking");
        b5.setFont(new Font("Raleway",Font.BOLD,12));
        b5.setBounds(320,315,250,30);
        b5.setBackground(Color.white);
        add(b5);
        
        b6= new JCheckBox("SMS allerts");
        b6.setFont(new Font("Raleway",Font.BOLD,12));
        b6.setBounds(120,340,200,30);
        b6.setBackground(Color.white);
        add(b6);
        
        b7= new JCheckBox("Cheque book");
        b7.setFont(new Font("Raleway",Font.BOLD,12));
        b7.setBounds(320,340,250,30);
        b7.setBackground(Color.white);
        add(b7);
        
        b8= new JCheckBox("I hereby declares that above info is correct");
        b8.setFont(new Font("Raleway",Font.BOLD,10));
        b8.setBounds(100,390,400,30);
        b8.setBackground(Color.white);
        add(b8);
       
        next = new JButton("Submit");
         next.setBounds(200,450,80,20);
        next.setBackground(Color.green);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("Canel");
         cancel.setBounds(340,450,80,20);
        cancel.setBackground(Color.red);
        cancel.addActionListener(this);
        add(cancel);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String accountType=null;
            if(b1.isSelected()){
                accountType="Current Account";
                
            }
            else if(b2.isSelected()){
                accountType="Saving Account";  
            }
            else if(b3.isSelected()){
                accountType="Deposit Account";
            }
            
            Random random=new Random();
            String cardnumber = ""+Math.abs((random.nextLong() % 90000000L)+1020304000000000L);
            
            String pinn=""+ Math.abs((random.nextLong()%90000L)+1000L);
            
            String facility="";
            if(b4.isSelected()){
                facility=facility+"ATM Card";
            }
            else if(b5.isSelected()){
                facility=facility+"Online banking";
            }
            else if(b6.isSelected()){
                facility=facility+"SMS Allert";
            }
            else if(b7.isSelected()){
                facility=facility+"Cheque Book";
            }
            try {
                if(!b8.isSelected()){
                    JOptionPane.showMessageDialog(null,"declaration require");
                }
                else{
                    Conn conn=new Conn();
                    String query1 = "insert into signupt values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinn+"','"+facility+"')";
                    String query2 = "insert into loginatm values('"+formno+"','"+cardnumber+"','"+pinn+"')";
                    
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n PIN : "+pinn);
                }
                setVisible(false);
                new Deposit(pinn).setVisible(false);
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Signupt("");
    }
}
