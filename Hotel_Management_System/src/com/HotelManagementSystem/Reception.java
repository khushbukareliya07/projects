package com.HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton customerform_button,
            room_button,
            department_button,
            employee_info_button,
            customer_info_button,
            manager_info_button,
            checkout_button,
            room_status_update_button,
            availability_status_button,
            pickup_service_button,
            search_available_room_button,
            logout_button;

    Reception()
    {
        customerform_button = new JButton("New Customer Details");
        customerform_button.setBackground(Color.BLACK);
        customerform_button.setForeground(Color.WHITE);
        customerform_button.setBounds(10,30,200,30);
        customerform_button.addActionListener(this);
        add(customerform_button);

        room_button = new JButton("Room");
        room_button.setBackground(Color.BLACK);
        room_button.setForeground(Color.WHITE);
        room_button.setBounds(10,70,200,30);
        room_button.addActionListener(this);
        add(room_button);

        department_button = new JButton("Department");
        department_button.setBackground(Color.BLACK);
        department_button.setForeground(Color.WHITE);
        department_button.setBounds(10,110,200,30);
        department_button.addActionListener(this);
        add(department_button);

        employee_info_button = new JButton("Employee Details");
        employee_info_button.setBackground(Color.BLACK);
        employee_info_button.setForeground(Color.WHITE);
        employee_info_button.setBounds(10,150,200,30);
        employee_info_button.addActionListener(this);
        add(employee_info_button);

        customer_info_button = new JButton("Customer Details");
        customer_info_button.setBackground(Color.BLACK);
        customer_info_button.setForeground(Color.WHITE);
        customer_info_button.setBounds(10,190,200,30);
        customer_info_button.addActionListener(this);
        add(customer_info_button);

        manager_info_button = new JButton("Managerial Details");
        manager_info_button.setBackground(Color.BLACK);
        manager_info_button.setForeground(Color.WHITE);
        manager_info_button.setBounds(10,230,200,30);
        manager_info_button.addActionListener(this);
        add(manager_info_button);

        checkout_button = new JButton("Check-Out");
        checkout_button.setBackground(Color.BLACK);
        checkout_button.setForeground(Color.WHITE);
        checkout_button.setBounds(10,270,200,30);
        checkout_button.addActionListener(this);
        add(checkout_button);

        availability_status_button = new JButton("Update Availability Status");
        availability_status_button.setBackground(Color.BLACK);
        availability_status_button.setForeground(Color.WHITE);
        availability_status_button.setBounds(10,310,200,30);
        availability_status_button.addActionListener(this);
        add(availability_status_button);

        room_status_update_button = new JButton("Update Room Status");
        room_status_update_button.setBackground(Color.BLACK);
        room_status_update_button.setForeground(Color.WHITE);
        room_status_update_button.setBounds(10,350,200,30);
        room_status_update_button.addActionListener(this);
        add(room_status_update_button);

        pickup_service_button = new JButton("Pick-up Service");
        pickup_service_button.setBackground(Color.BLACK);
        pickup_service_button.setForeground(Color.WHITE);
        pickup_service_button.setBounds(10,390,200,30);
        pickup_service_button.addActionListener(this);
        add(pickup_service_button);

        search_available_room_button = new JButton("Search Room");
        search_available_room_button.setBackground(Color.BLACK);
        search_available_room_button.setForeground(Color.WHITE);
        search_available_room_button.setBounds(10,430,200,30);
        search_available_room_button.addActionListener(this);
        add(search_available_room_button);

        logout_button = new JButton("Logout");
        logout_button.setBackground(Color.BLACK);
        logout_button.setForeground(Color.WHITE);
        logout_button.setBounds(10,470,200,30);
        logout_button.addActionListener(this);
        add(logout_button);

        //Config to add Image on the Right part of the screen
        ImageIcon reception_image =  new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/fourth.jpg"));
        JLabel reception_image_label = new JLabel(reception_image);
        reception_image_label.setBounds(250,30,500,470);
        add(reception_image_label);


        //General Layout configuration
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(550,200,800,570);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == customerform_button)
        {

        }
        else if(actionEvent.getSource() == room_button)
        {
            new Room().setVisible(true);
            this.setVisible(false);
        }
        else if(actionEvent.getSource() == department_button)
        {

        }
        else if(actionEvent.getSource() == employee_info_button)
        {
            new EmployeeDetails().setVisible(true);
            this.setVisible(false);
        }
        else if(actionEvent.getSource() == customer_info_button)
        {

        }
        else if(actionEvent.getSource() == manager_info_button )
        {
            new ManagerInformation().setVisible(true);
            this.setVisible(false);

        }
        else if(actionEvent.getSource() == checkout_button)
        {

        }
        else if(actionEvent.getSource() == availability_status_button)
        {

        }
        else if(actionEvent.getSource() == room_status_update_button)
        {

        }
        else if(actionEvent.getSource() == pickup_service_button)
        {

        }
        else if(actionEvent.getSource() == search_available_room_button)
        {

        }
        else if(actionEvent.getSource() == logout_button)
        {

        }
    }
}
