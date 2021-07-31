package com.HotelManagementSystem;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends  JFrame implements ActionListener {

    private JPanel contentpane;
    private JTextField t_add_rooms,t_price;
    private JComboBox availability_comboBox, status_comboBox, bed_type_comboBox, comboBox_3;
    JButton add_room_button,cancel_button;
    Choice c1;

    public AddRooms()
    {
        //Title config
        JLabel add_rooms = new JLabel("ADD ROOMS");
        add_rooms.setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 25));
        add_rooms.setBounds(150, 20, 200, 20);
        add(add_rooms);
        //contentPane.add(add_rooms);

        //******** Form config starts here ********

        //>>Add Room Label
        JLabel room_number = new JLabel("Room Number");
        room_number.setFont(new Font("Tahoma", Font.PLAIN, 16));
        room_number.setBounds(60, 80, 120, 30);
        add(room_number);
        //contentPane.add(room_number);

        t_add_rooms = new JTextField();
        t_add_rooms.setBounds(200,80,150,30);
        add(t_add_rooms);

        //>>Room Availability label
        JLabel availability = new JLabel("Available");
        availability.setFont(new Font("Tahoma", Font.PLAIN, 16));
        availability.setBounds(60, 130, 120, 30);
        add(availability);
        //contentPane.add(availability);

        availability_comboBox = new JComboBox(new String[] {"Available", "Occupied"});
        availability_comboBox.setBounds(200,130,150,30);
        availability_comboBox.setBackground(Color.WHITE);
        add(availability_comboBox);

        //>>Status label
        JLabel room_cleaning_status = new JLabel("Cleaning Status");
        room_cleaning_status.setFont(new Font("Tahoma", Font.PLAIN, 16));
        room_cleaning_status.setBounds(60, 180, 120, 30);
        add(room_cleaning_status);
        //contentPane.add(room_cleaning_status);

        status_comboBox = new JComboBox(new String[] {"Cleaned", "Need Attention"});
        status_comboBox.setBounds(200,180,150,30);
        status_comboBox.setBackground(Color.WHITE);
        add(status_comboBox);

        //>>price label
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);
        //contentPane.add(price);

        t_price = new JTextField();
        t_price.setBounds(200,230,150,30);
        add(t_price);

        //>>Bed Type
        JLabel bed_type = new JLabel("Bed Type");
        bed_type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bed_type.setBounds(60, 280, 120, 30);
        add(bed_type);
        //contentPane.add(price);

        bed_type_comboBox = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bed_type_comboBox.setBounds(200,280,150,30);
        bed_type_comboBox.setBackground(Color.WHITE);
        add(bed_type_comboBox);

        //Adding Button Configurations.
        //>>Add Room Button config
        add_room_button = new JButton("ADD ROOM");
        add_room_button.setBounds(60,350,130,30);
        add_room_button.setBackground(Color.BLACK);
        add_room_button.setForeground(Color.WHITE);
        add_room_button.addActionListener(this);
        add(add_room_button);

        //>>Cancel Button config
        cancel_button = new JButton("CANCEL");
        cancel_button.setBounds(220,350,130,30);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        add(cancel_button);


        //Config to add Image on the Right part of the screen
        ImageIcon room_image =  new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/room.jpg"));
        JLabel room_image_label = new JLabel(room_image);
        room_image_label.setBounds(400,30,500,350);
        add(room_image_label);


        //Default Config
        getContentPane().setBackground(Color.WHITE);
        setBounds(500,200,940,470);
        //setContentPane();
        setLayout(null);
        setVisible(true);
    }



    /* **** Main Method **** */
    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == add_room_button)
        {
            String room = t_add_rooms.getText();
            String available = (String) availability_comboBox.getSelectedItem();
            String status = (String) status_comboBox.getSelectedItem();
            String price = t_price.getText();
            String bed_type = (String) bed_type_comboBox.getSelectedItem();

            ConnectionConfig conn = new ConnectionConfig();

            try
            {
                String str = "INSERT into ROOM_DETAILS values ('"+room+"', '"+available+"', '"+status+"', '"+price+"', '"+bed_type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Addded");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }
        else if(actionEvent.getSource() == cancel_button)
        {
            this.setVisible(false);
        }

    }
}
