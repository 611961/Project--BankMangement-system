package bankms;
import javax.swing.*;
import java.awt.*;            //to get classes related image,properties of color and font
import java.awt.event.*;      // to perform or catch an action
import java.sql.*;


public class Login extends JFrame implements ActionListener{                    //using inhrtnc to use swing package
                                                                            //for implement action we must overridemethod
    JButton login,signup,clear;
    JTextField cardField;
    JPasswordField pinField;                        //now whatever we enter pswd it show in dots
    
    Login(){                        
        
        setLayout(null);    //otherwiese it will take general not custom
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atmicon.png"));   // ii is used to put img and loader clas used to get resource from system
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);  
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);             //contains the img resizing
        label.setBounds(70,10,100,100);         // shift the image to any loaction in the frame
        
        add(label);                     
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200,20,400,40);                  // rowspace to place ,clm to place,space of writtentext,hight of txt
        text.setFont(new Font("Osward",Font.ITALIC,30));
        add(text);
        
        JLabel cardno=new JLabel("Card NO.");
        cardno.setBounds(190,90,400,40);
        cardno.setFont(new Font("Black",Font.BOLD,18));
        add(cardno);
         cardField=new JTextField();
        cardField.setBounds(290,100,190,25);
        cardField.setFont(new Font("Arial",Font.BOLD,12));
        add(cardField);
        
        JLabel pin=new JLabel("PIN :");
        pin.setBounds(210,143,100,40);
        pin.setFont(new Font("Black",Font.BOLD,18));
        add(pin);
        pinField=new JPasswordField();
        pinField.setBounds(290,150,190,25);
        add(pinField);
        
         login= new JButton("Log In");
        login.setBounds(310,210,70,25);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
         clear= new JButton("Clear");
        clear.setBounds(390,210,70,25);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("SignUp");
        signup.setBounds(325,260,100,25);
        signup.setBackground(Color.green);
        signup.setForeground(Color.white);
         signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("Automated Teller Machine");      // heading of frame
        setSize(720,400);        // define the length and width of frame
        setVisible(true);          // ye use nhi krenge to frame nhi dikhega
        setLocation(350,200);         // loacation of frame to centre
    }
    
    public void actionPerformed(ActionEvent ae){      // actionevnt cls tells which btn is clicked
        if(ae.getSource() == clear){
            cardField.setText("");
            pinField.setText("");
        }    
             else if(ae.getSource()==login){
            Conn cc =new Conn();
            String cn= cardField.getText();
            String pinnumber=pinField.getText();             // cut due to password field
            String query="select * from loginatm where cardNumber='"+cn+"' and Pin='"+pinnumber+"'";
            
            try {
                ResultSet rs = cc.s.executeQuery(query);            //resullt in sql package so import sql ,DDL command
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin");
                }
                
            }
            catch(Exception e){
                System.out.print(e);
            }
    }
        else if(ae.getSource()==signup){
            
            setVisible(false);
            new Signupp().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
