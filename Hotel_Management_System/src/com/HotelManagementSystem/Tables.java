//package com.HotelManagementSystem;
//
//import javax.swing.*;
//import java.sql.Statement;
//import java.sql.*;
//import java.util.concurrent.ExecutionException;
//import javax.swing.JOptionPane;
//
//public class Tables {
//    public static void main(String[] args)
//    {
//        Connection con = null;
//        Statement st = null;
//
//        try
//        {
//            con = ConnectionConfig.getConnection();
//            st = con.createStatement();
//            st.executeUpdate("create table users(firstname varchar(200),lastname varchar(200), email varchar(200), password varchar(200))");
//            JOptionPane.showMessageDialog(null, "Table Created Successfully");
//        }
//        catch (Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//        finally {
//            try
//            {
//                con.close();
//                st.close();
//            }
//            catch (Exception e)
//            {
//
//            }
//        }
//
//    }
//
//}
