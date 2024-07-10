package bankms;

 import javax.swing.*;
 import java.awt.*;
 import java.sql.*;

public class Balance extends JFrame{
    String pin;
    
    
     Balance(String pin){
         
         this.pin=pin;
         
         setLayout(null);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atmm.jpg"));
         Image i2= i1.getImage().getScaledInstance(900,780,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
         
         JLabel image = new JLabel(i3);
         image.setBounds(0, 0,900, 900);
         add(image);
        
        
         Conn c = new Conn();
         int balance = 0;
         try{
             ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pin+"'");
              balance = 0;
             while(rs.next()){
                 if(rs.getString("type").equals("deposit")){
                     balance+= Integer.parseInt(rs.getString("amount"));
                 }
                 else{
                     balance -= Integer.parseInt(rs.getString("amount"));
                 }
             }
         }
         catch(Exception e){
             System.out.println(e);
         }
         
         JLabel n= new JLabel("Your Bank Balance is: ");
         n.setFont(new Font("System",Font.BOLD,16));
         n.setBounds(160,350,400,30);
         n.setForeground(Color.white);
         image.add(n);
         
          JLabel nn= new JLabel("Rs."+balance);
         nn.setFont(new Font("System",Font.BOLD,16));
         nn.setBounds(290,400,200,30);
         nn.setForeground(Color.white);
         image.add(nn);
         
                 
        setSize(900,900);
        setLocation(300,20);
        setVisible(true);
     }
    public static void main(String args[    ]){
       new Balance("");
    }
}
