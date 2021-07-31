package com.HotelManagementSystem;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertUpdateDelete {
    public static Connection con = null;
    public static Statement st;
    public static ResultSet executingQuery(String query)
    {
        try
        {
            System.out.println("Inside the try block of execute query");
            return st.executeQuery(query);
        }
        catch (Exception e)
        {
            return null;
        }
    }


    public static void setData(String query, String message)
    {
//        Connection con = null;
//        Statement st;

//        try
//        {
//            con = ConnectionConfig.getConnection();
//            st = con.createStatement();
//            st.executeUpdate(query);
//            if(!message.equals(""))
//            {
//                JOptionPane.showMessageDialog(null,message);
//
//            }
//
//        }
//        catch (Exception e)
//        {
//            JOptionPane.showMessageDialog(null,e);
//        }
//        finally
//        {
//            try
//            {
//
//            }
//            catch (Exception e)
//            {
//
//            }
//        }
    }
}
