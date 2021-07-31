package com.HotelManagementSystem;

//import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {

    //Globally delacring variables here !
    JLabel l_username, l_password; //l1, l2
    JTextField t_username; //t1
    JPasswordField t_password; // t2
    JButton b_login, b_forgotpassword, b_cancel; //b1, b2
    Login()
    {
        //adding background Image to the login page
        ImageIcon mainImage = new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/Login_Background.jpg"));
        JLabel main_label = new JLabel(mainImage);
        main_label.setBounds(0,0,600,400);
        add(main_label);



        //title of username and passwords!
        l_username = new JLabel("Username :");
        l_username.setBounds(130,60,120,30);
        l_username.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
        l_username.setForeground(Color.WHITE);
        main_label.add(l_username);

        l_password = new JLabel("Password :");
        l_password.setBounds(130,110,120,30);
        l_password.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
        l_password.setForeground(Color.WHITE);
        main_label.add(l_password);

        //Text field for user name and password.
        t_username = new JTextField();
        t_username.setBounds(255,60, 150,32);
        main_label.add(t_username);

        t_password = new JPasswordField();
        t_password.setBounds(255,110, 150,32);
        main_label.add(t_password);

        //Creating buttons!
        b_login = new JButton("Login");
        b_login.setBackground(Color.BLACK);
        b_login.setForeground(Color.WHITE);
        b_login.setBounds(150, 190, 140, 32);
        b_login.addActionListener(this);
        main_label.add(b_login);

        b_cancel = new JButton("Cancel");
        b_cancel.setBackground(Color.BLACK);
        b_cancel.setForeground(Color.WHITE);
        b_cancel.setBounds(310, 190,140,32);
        b_cancel.addActionListener(this);
        main_label.add(b_cancel);



        setLayout(null);
        setBounds(500,300,600,400); // Login page size
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent buttonPressed)
    {
        if(buttonPressed.getSource()==b_login)
        {
            String email = t_username.getText();
            String password = t_password.getText();
            ConnectionConfig connection_obj = new ConnectionConfig();

            String str = "SELECT * FROM users WHERE email = '"+email+"' AND password =  '"+password+"'";

            try
            {
                ResultSet result = connection_obj.s.executeQuery(str);
                if(result.next()) // next function jumps from column to column
                {
                    System.out.println("Inside if");
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. ");
                    this.setVisible(true);
                }
            }
            catch (Exception e)
            {

            }

        }
        else if (buttonPressed.getSource()==b_cancel)
        {
            this.setVisible(false);
            new HotelmanagementSystem().setVisible(true);
            //System.exit(0);
        }
        else
        {

        }
    }
}
