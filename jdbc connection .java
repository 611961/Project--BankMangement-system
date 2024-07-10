package bankms;

import java.sql.*;

public class Conn {

    Connection c; //creating connection
    Statement s; 

    public Conn() {

        try {
        
            c = DriverManager.getConnection("jdbc:mysql:///project", "root", "Ns174312@");
            s = c.createStatement();

        } catch (Exception e) { 
            System.out.println(e);
        }
    }
    
}
