package database;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection(){
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "your_password");
            System.out.println("Database Connected Susscessfully");
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}


