
package bankms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5;
    String pinnumber;
    
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("logos/atmm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction :");
        text.setFont(new Font("Raleway",Font.ITALIC,16));
        text.setBounds(200,290,400,33);
        text.setForeground(Color.white);
        image.add(text);
        
        b1=new JButton("Deposit") ;
        b1.addActionListener(this);
        b1.setBounds(180,370,90,20);
        add(b1);
        
        b2=new JButton("Cash Withdrwal") ;
        b2.setBounds(380,370,125,20);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Balance Receipt");
        b3.setBounds(180,400,130,20);
        b3.addActionListener(this);
        add(b3);
        
        b4=new JButton("Change pin") ;
        b4.setBounds(380,400,125,20);
        b4.addActionListener(this);
        add(b4);
        
        b5=new JButton("Exit") ;
        b5.setBounds(395,442,80,20);
        b5.addActionListener(this);
        add(b5);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(false);              // full screen pe frame dikhegi not title no close tag
        setVisible(true);
    }
    
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b5){
            System.exit(0);
        }
        else if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==b2){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==b3){
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==b4){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transaction("");
    }
}
