package bankms;

import javax.swing.*;
import java.awt.*;            
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Signupp extends JFrame implements ActionListener{
    
    long random;
    JTextField namField,fnamField,gmailField, adrsField, pcodField, sttField;
    JButton next;
    JRadioButton male ,female ,married,unmrid;
    JDateChooser dtchoose;
        
    Signupp() {
        
        setLayout(null);
        
        Random ran=new Random();
         random=(Math.abs(ran.nextLong() % 9000L )+ 1000L);     //it gives 4 random numbers
        
        setSize(1000,800);
        setLocation(200,20);
        setVisible(true);
        setTitle("Appliaction Form");
        getContentPane().setBackground(Color.white);
        
        JLabel topp=new JLabel("Form no."+random);
        topp.setFont(new Font("Raleway",Font.BOLD,35));
        topp.setBounds(350,20,600,30);
        add(topp);
        
        JLabel details=new JLabel("-: DeatilsPage 1/3 :-");
        details.setFont(new Font("Raleway",Font.BOLD,25));
        details.setBounds(375,65,600,35);
        add(details);
        
         JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,17));
        name.setBounds(180,165,600,20);
        add(name);
        
         namField = new JTextField();
        namField.setFont(new Font("Raleway",Font.BOLD,12));
        namField.setBounds(350,165,200,20);
        add(namField);
        
        
        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,17));
        fname.setBounds(180,195,600,20);
        add(fname);
        
         fnamField = new JTextField();
        fnamField.setFont(new Font("Raleway",Font.BOLD,12));
        fnamField.setBounds(350,195,200,20);
        add(fnamField);
        
          JLabel dob=new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,17));
        dob.setBounds(180,230,600,20);
        add(dob);
        
         dtchoose=new JDateChooser();
        dtchoose.setBounds(350,230,200,20);
        add(dtchoose);
        
        JLabel gen=new JLabel("Gender :");
        gen.setFont(new Font("Raleway",Font.BOLD,17));
        gen.setBounds(180,265,600,20);
        add(gen);
        
         male=new JRadioButton("Male");
        male.setBounds(350,265,60,20);
        add(male);
         female=new JRadioButton("Female");
        female.setBounds(450,265,70,20);
        add(female);
        
        JLabel mail=new JLabel("Gmail :");
        mail.setFont(new Font("Raleway :",Font.BOLD,17));
        mail.setBounds(180,300,600,20);
        add(mail);
        
        gmailField = new JTextField();
        gmailField.setFont(new Font("Raleway",Font.BOLD,12));
        gmailField.setBounds(350,300,200,20);
        add(gmailField);
        
        JLabel marital=new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway",Font.BOLD,17));
        marital.setBounds(180,335,600,20);
        add(marital);
        
         married=new JRadioButton("Married");
        married.setBounds(350,335,80,20);
        add(married);
          unmrid=new JRadioButton("Unmarried");
        unmrid.setBounds(450,335,85,20);
        add(unmrid);
        
        JLabel adr=new JLabel("Address :");
        adr.setFont(new Font("Raleway",Font.BOLD,17));
        adr.setBounds(180,370,600,20);
        add(adr);
        
         adrsField = new JTextField();
        adrsField.setFont(new Font("Raleway",Font.BOLD,12));
        adrsField.setBounds(350,370,200,30);
        add(adrsField);
        
        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,17));
        state.setBounds(180,420,600,20);
        add(state);
        
          sttField = new JTextField();
        sttField.setFont(new Font("Raleway",Font.BOLD,12));
        sttField.setBounds(350,420,200,20);
        add(sttField);
        
        JLabel pincod=new JLabel("PIN Code :");
        pincod.setFont(new Font("Raleway",Font.BOLD,17));
        pincod.setBounds(180,450,600,20);
        add(pincod);
        
        pcodField = new JTextField();
        pcodField.setFont(new Font("Raleway",Font.BOLD,12));
        pcodField.setBounds(350,450,200,20);
        add(pcodField);
        
         next=new JButton("Next");
        next.setBounds(450,500,80,20);
        next.setBackground(Color.green);
        next.addActionListener(this);
        add(next);
        
    }
    
      public void actionPerformed(ActionEvent ae){ 
      
      String formno=""+random;
      String name=namField.getText();     //gettxt s txtfield ki value nikal skte hai
          String fnam=fnamField.getText();
          String dob= ((JTextField) dtchoose.getDateEditor().getUiComponent()).getText();
          String gender=null;
          if(male.isSelected()){
              gender="Male";
          }
          else if (female.isSelected()){
              gender="female";
          }
          
          String mail=gmailField.getText();
          String marital=null;
          if(married.isSelected()){
              marital="Married";
          }
          else if(unmrid.isSelected()){  
              marital="Unmarried";
          }
          
          String addr=adrsField.getText();  
          String state=sttField.getText();
          String pincod=pcodField.getText();
            
          try {
              if(name.equals("")){
                  JOptionPane.showMessageDialog(null,"Name is required");         //agr khali name hua to warn krega
              }
              else{
                  Conn c= new Conn();
                  String query = "insert into signup values('"+formno+"','"+name+"','"+fnam+"','"+dob+"','"+gender+"','"+marital+"','"+addr+"','"+state+"','"+pincod+"')";
                  c.s.executeUpdate(query);   
                  
                  setVisible(false);            //setvisible comes under Jframe so it will not work until we extends jframe in next clas
                  new Signuptwo(formno).setVisible(true);   //pass theformno and open dcmnt 2 after fill
              }
          }
          catch(Exception e){
              System.out.println(e);
          }
      }
    
    public static void main(String args[]){
        new Signupp();
    }   
}
