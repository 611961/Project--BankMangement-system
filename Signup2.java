package bankms;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Signuptwo extends JFrame implements ActionListener{
    

JLabel topp,religion,category,income,education,pan,adhaar,existing;
JComboBox box1,box2,box4;
JTextField box3,box5,box6;
JRadioButton box7,box8;
JButton next;
String formno;

    Signuptwo(String formno){  
        this.formno=formno;
        setLayout(null);
        
    setSize(1000,600);
    setLocation(300,20);
    setVisible(true);
    setTitle("Form - 2");
    getContentPane().setBackground(Color.white);
    
     topp= new JLabel("Details form 2/3");
    topp.setFont(new Font("Raleway",Font.BOLD,30));
    topp.setBounds(350,20,600,25); 
    add(topp);
    
     religion=new JLabel("Religion:");
    religion.setFont(new Font("Raleway",Font.BOLD,18));
    religion.setBounds(200,170,300,22);
    add(religion);
    
        String val1[] =  {"HINDU","MUSLIM","SIKH","CHRISTIAN"};
     box1=new JComboBox(val1);
    box1.setBounds(400,170,200,22);
    add(box1);
    
     category = new JLabel("Category:");
    category.setFont(new Font("Raleway",Font.BOLD,18));
    category.setBounds(200,210,300,24);
    add(category);
    
    String val2[]={"Gen","SC","OBC","Other"};
     box2= new JComboBox(val2);
    box2.setBounds(400,210,200,22);
    add(box2);
    
     income = new JLabel("Income:");
    income.setFont(new Font("Raleway",Font.BOLD,18));
    income.setBounds(200,250,300,24);
    add(income);
    
     box3=new JTextField();
    box3.setBounds(400,250,200,25);
    box3.setFont(new Font ("raleway",Font.BOLD,14));
    add(box3);
        
    
     education =new JLabel("Edu.Qualification:");
    education.setFont(new Font("raleway",Font.BOLD,18));
    education.setBounds(200,290,200,25);
    add(education);
    
    String []val3={"Metric","+2","Graduate"};
     box4=new JComboBox(val3);
    box4.setBounds(402,290,200,25);
    add(box4);
      
      pan =new JLabel("Pan NO.:");
    pan.setFont(new Font("raleway",Font.BOLD,18));
    pan.setBounds(200,325,200,25);
    add(pan);
    
     box5 =new JTextField();
    box5.setBounds(400,325,200,22);
    box5.setFont(new Font ("raleway",Font.BOLD,14));
    add(box5);
    
     adhaar =new JLabel("Adhar NO.:");
    adhaar.setFont(new Font("raleway",Font.BOLD,18));
    adhaar.setBounds(200,355,200,25);
    add(adhaar);
    
     box6 =new JTextField();
    box6.setBounds(400,355,200,22);
    box6.setFont(new Font ("raleway",Font.BOLD,14));
    add(box6);
    
     existing =new JLabel("Existing Ac.:");
    existing.setFont(new Font("raleway",Font.BOLD,18));
    existing.setBounds(200,385,200,25);
    add(existing);
    
     box7=new JRadioButton("Yes");
     box7.setBackground(Color.white);
    box7.setBounds(400,385,50,25);
    add(box7);
    
      box8=new JRadioButton("No");
       box8.setBackground(Color.white);
    box8.setBounds(500,385,50,25);
    add(box8);
    
    next = new JButton("Next");
    next.setBackground(Color.green);
    next.setBounds(460,450,70,25);
    next.addActionListener(this);
    add(next);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String) box1.getSelectedItem();
        String scategory=(String) box2.getSelectedItem();
        String sincome=(String) box3.getText();
        String sedu=(String) box4.getSelectedItem();
        String span=(String) box5.getText();
        String sadh=(String) box6.getText();
        String exists=null;
        if(box7.isSelected()){
            exists="Yes";
        }
        else if(box8.isSelected()){
            exists="NO";
        }
        //////////////noww we want form number from signup class to know which aplicant data it is
        try{
            
           if (box7.isSelected() && box8.isSelected()) {
            JOptionPane.showMessageDialog(null, "Both checkboxes can't be selected"); // Message shown when both are checked
                        }
           else{
            Conn c = new Conn();
            String query= "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sedu+"','"+span+"','"+sadh+"','"+exists+"')";
         c.s.executeUpdate(query);
         
        new Signupt(formno).setVisible(true);  
            }
           
           //signipthree object
           setVisible(false);
           new Signupt(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    
    public static void main(String args[]){
        new Signuptwo("");        //now its not a default constructor bcz we passes some value to it , so pass we ""
    }
}
