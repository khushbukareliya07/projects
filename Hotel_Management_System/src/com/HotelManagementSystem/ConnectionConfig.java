package com.HotelManagementSystem;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionConfig {
    private String url = "jdbc:mysql://localhost:3306/hotel";
    private String userId = "root";
    private String password = "password";

//    public  static Connection getConnection()
//    {
//        Connection conn;
//        //Statement s;
//        try
//        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///hotel", "root", "password"); //interface name, db name, url + root+password
//           // s = conn.createStatement();
//            return conn;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }

        Connection c;
        Statement s;

        public ConnectionConfig()
        {
            try
            {
                System.out.println("Inside connection config's try!");
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection(url, userId,password);
                System.out.println("Connection established");
                s = c.createStatement();
                System.out.println("Try end!");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
}


