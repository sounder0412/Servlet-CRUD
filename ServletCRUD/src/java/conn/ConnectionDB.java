package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB 
{
    public static Connection getConnection()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}