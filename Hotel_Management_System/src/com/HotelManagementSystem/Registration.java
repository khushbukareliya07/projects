package com.HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Registration extends JFrame implements ActionListener {
    JLabel l_firstname, l_lastname, l_email, l_gender, l_password,l_confirmpassword;
    JTextField t_firstname, t_lastname, t_email;
    JPasswordField t_password,t_confirmpassword;


    Registration()
    {
        //adding background Image
        ImageIcon mainImage = new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/Login_Background.jpg"));
        JLabel main_label = new JLabel(mainImage);
        main_label.setBounds(0,0,800,600);
        add(main_label);

        //Label Section
        //Label section >> First name
        l_firstname = new JLabel("First Name");
        l_firstname.setBounds(100,60,160,30);
        l_firstname.setFont(new Font("Serif",Font.BOLD |Font.ITALIC, 20));
        l_firstname.setForeground(Color.WHITE);
        main_label.add(l_firstname);

        //Label section >> Last name
        l_lastname = new JLabel("Last Name");
        l_lastname.setBounds(100,120,160,30);
        l_lastname.setFont(new Font("Serif",Font.BOLD |Font.ITALIC, 20));
        l_lastname.setForeground(Color.WHITE);
        main_label.add(l_lastname);

        //Label - Section >> Email
        l_email = new JLabel("Email ID");
        l_email.setBounds(100,180,160,30);
        l_email.setFont(new Font("Serif",Font.BOLD |Font.ITALIC, 20));
        l_email.setForeground(Color.WHITE);
        main_label.add(l_email);

        //Label section >> Password
        l_password = new JLabel("Password");
        l_password.setBounds(100,240,160,30);
        l_password.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
        l_password.setForeground(Color.WHITE);
        main_label.add(l_password);

        //Label section >> Confirm Password
        l_confirmpassword = new JLabel("Confirm Password");
        l_confirmpassword.setBounds(100,300,160,30);
        l_confirmpassword.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
        l_confirmpassword.setForeground(Color.WHITE);
        main_label.add(l_confirmpassword);


        //Inout field Section Starts here
        t_firstname = new JTextField();
        t_firstname.setBounds(300,60, 200,32);
        main_label.add(t_firstname);

        t_lastname = new JTextField();
        t_lastname.setBounds(300,120, 200,32);
        main_label.add(t_lastname);

        t_email = new JTextField();
        t_email.setBounds(300,180, 200,32);
        main_label.add(t_email);

        t_password = new JPasswordField();
        t_password.setBounds(300,240, 200,32);
        main_label.add(t_password);

        t_confirmpassword = new JPasswordField();
        t_confirmpassword.setBounds(300,300, 200,32);
        main_label.add(t_confirmpassword);


        // Adding Buttons!

        JButton register_button = new JButton("Register"); //b1
        register_button.setFont(new Font("Times Roman", Font.BOLD , 25));
        register_button.setBackground(Color.WHITE);
        register_button.setForeground(Color.BLACK);
        register_button.setBounds(250,390,150,40);
        main_label.add(register_button); // we are adding on Image so, we use label 1
        register_button.addActionListener(this::actionPerformed);

        //Login Button
        JButton login_button = new JButton("Login"); //b1
        login_button.setFont(new Font("Times Roman", Font.BOLD , 25));
        login_button.setBackground(Color.WHITE);
        login_button.setForeground(Color.BLACK);
        login_button.setBounds(450,390,180,40);
//        login_button.addActionListener(this);
        main_label.add(login_button); // we are adding on Image so, we use label 1
        login_button.addActionListener(this::actionPerformedinLogin);


        //General Layout
        setLayout(null);
        setBounds(500,300,800,600);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstname = t_firstname.getText();
        String lastname = t_lastname.getText();
        String email = t_email.getText();
        String password = t_password.getText();

        //Inserting Data to DB
        ConnectionConfig conn = new ConnectionConfig();
        String query = "INSERT into users values('"+firstname+"', '"+lastname+"','"+email+"', '"+password+"' )";
        if(firstname.equals("") || lastname.equals("") || email.equals("") || password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Each field is mandatory. Please Enter the valid data.");
        }
        else
        {
            try
            {
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "You have Registered as an Admin Successfully.");
                this.setVisible(false);
                new Login().setVisible(true);
            }
            catch (Exception exception)
            {
                System.out.println(exception);
            }
        }
    }

    public void actionPerformedinLogin(ActionEvent e)
    {
        new Login().setVisible(true);
        setVisible(false);
    }

//    private void
}
