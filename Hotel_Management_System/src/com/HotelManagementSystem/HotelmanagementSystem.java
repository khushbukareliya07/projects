package com.HotelManagementSystem;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelmanagementSystem extends  JFrame implements ActionListener {

    JButton admin_login_button, frontdesk_login_button, admin_register_button, customer_registration_button;
    //Everything related to Jframe will be in constructor.
    HotelmanagementSystem()
    {
        setBounds(0,0,1900,1000);
        //setBounds(300,200,1365,565); // now u don't need seprate location and size. first two are location and thn size.
        //setSize(400,400);

        //setLocation(300,300); //by default location is 0,0

        ImageIcon mainImage = new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/HotelCover.jpg")); //i1, putting image into a label, we can't directly put image.
        JLabel label1 = new JLabel(mainImage);//label1 = l1
        label1.setBounds(0,0,1900,1000);
        add(label1);

        JLabel label2_title = new JLabel("Hotel Management System"); //l2
        label2_title.setBounds(20,800,1000,90);
        label2_title.setForeground(Color.WHITE);
        label2_title.setFont(new Font("Serif", Font.BOLD, 70));
        label1.add(label2_title);

        setLayout(null); // by default it will be Border Layout.
        setVisible(true); //every frame is set visible fault by default so we need to show it as true!,

        admin_login_button = new JButton("Administration Login"); //b1
        admin_login_button.setFont(new Font("Times Roman", Font.BOLD , 25));
        admin_login_button.setBackground(Color.WHITE);
        admin_login_button.setForeground(Color.BLACK);
        admin_login_button.setBounds(1150,800,300,40);
        admin_login_button.addActionListener(this);
        label1.add(admin_login_button); // we are adding on Image so, we use label 1

        frontdesk_login_button = new JButton("Front-Desk Login"); //b1
        frontdesk_login_button.setFont(new Font("Times Roman", Font.BOLD , 25));
        frontdesk_login_button.setBackground(Color.WHITE);
        frontdesk_login_button.setForeground(Color.BLACK);
        frontdesk_login_button.setBounds(1500,800,300,40);
//        login_button_customer.addActionListener(this);
        label1.add(frontdesk_login_button); // we are adding on Image so, we use label 1

        admin_register_button = new JButton("Admin Registration"); //b1
        admin_register_button.setFont(new Font("Times Roman", Font.BOLD , 25));
        admin_register_button.setBackground(Color.WHITE);
        admin_register_button.setForeground(Color.BLACK);
        admin_register_button.setBounds(1150,900,300,40);
        admin_register_button.addActionListener(this);
        label1.add(admin_register_button); // we are adding on Image so, we use label 1

//        customer_registration_button = new JButton("Customer Registration"); //b1
//        customer_registration_button.setFont(new Font("Times Roman", Font.BOLD , 25));
//        customer_registration_button.setBackground(Color.WHITE);
//        customer_registration_button.setForeground(Color.BLACK);
//        customer_registration_button.setBounds(1500,900,350,40);
//        label1.add(customer_registration_button); // we are adding on Image so, we use label 1


        while (true) // This loop gives blinking effect to the Title - Hotel Manaement System
        {
            label2_title.setVisible(false);
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {

            }
            label2_title.setVisible(true);
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {

            }

        }
    }



    public static void main(String[] args) {
        new HotelmanagementSystem().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == admin_register_button)
        {
            new Registration().setVisible(true);
        }
        else if(actionEvent.getSource() == admin_login_button)
        {
            new Login().setVisible(true);
        }
        else if(actionEvent.getSource() == frontdesk_login_button)
        {
            new Reception().setVisible(true);
        }



        this.setVisible(false); // if you want to close the welcome page on opening Login Page.
    }
}
