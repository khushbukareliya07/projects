package com.HotelManagementSystem;

import net.proteanit.sql.DbUtils; // for this jar file : rs2xml is needed., this package is used to show the data that is loaded from the table.
//import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
//import org.apache.commons.dbutils.DbUtils;
import javax.swing.table.DefaultTableModel;

public class Room extends JFrame implements ActionListener {

    JTable display_room_table;
    public JButton load_data_button, go_back_button;

    Room()
    {
        //Adding Image on the Right Side.
        ImageIcon room_image =  new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/eight.jpg"));
        Image temp_image = room_image.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon room_final_Image = new ImageIcon(temp_image);
        JLabel room_image_label = new JLabel(room_final_Image);
        room_image_label.setBounds(510,0,600,600);
        add(room_image_label);


        //Adding Title Labels for the table Data
        JLabel title_room = new JLabel("Room Number");
        title_room.setFont(new Font("Tahoma" ,Font.BOLD , 12));
        title_room.setBounds(8,10,100,20);
        add(title_room);

        JLabel availability = new JLabel("Availability");
        availability.setFont(new Font("Tahoma" ,Font.BOLD , 12));
        availability.setBounds(120,10,80,20);
        add(availability);

        JLabel room_cleaning_status = new JLabel("Status");
        room_cleaning_status.setFont(new Font("Tahoma" ,Font.BOLD , 12));
        room_cleaning_status.setBounds(220,10,100,20);
        add(room_cleaning_status);

        JLabel room_price = new JLabel("Price");
        room_price.setFont(new Font("Tahoma" ,Font.BOLD, 12));
        room_price.setBounds(330,10,100,20);
        add(room_price);

        JLabel bed_type = new JLabel("Bed Type");
        bed_type.setFont(new Font("Tahoma" ,Font.BOLD , 12));
        bed_type.setBounds(415,10,100,20);
        add(bed_type);

        //Adding Data display field and Buttons
        display_room_table = new JTable();
        display_room_table.setBounds(2,40,510,400);
        add(display_room_table);

        load_data_button = new JButton("Load Data");
        load_data_button.setBackground(Color.BLACK);
        load_data_button.setForeground(Color.WHITE);
        load_data_button.setBounds(100,460,120,30);
        load_data_button.addActionListener(this::actionPerformed);
        add(load_data_button);

        go_back_button = new JButton("Go Back");
        go_back_button.setBackground(Color.BLACK);
        go_back_button.setForeground(Color.WHITE);
        go_back_button.setBounds(250,460,120,30);
        go_back_button.addActionListener(this::actionPerformed);
        add(go_back_button);

        //Default Configuration

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,200,1050,600);
        setVisible(true);
        showData();
    }



    //******** Method Implementation **********
    public static void main(String[] args) {
        new Room().setVisible(true);

    }
    public void showData() {
        try
        {
            ConnectionConfig conn = new ConnectionConfig();
            String str = "SELECT * FROM room_details";

            ResultSet result = conn.s.executeQuery(str);
            display_room_table.setModel(DbUtils.resultSetToTableModel(result));

        }
        catch(Exception e)
        {
            System.out.println("Unable to Load Data.");
        }
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == load_data_button)
        {
            showData();
//            try
//            {
//                ConnectionConfig conn = new ConnectionConfig();
//                String str = "SELECT * FROM room_details";
//                ResultSet result = conn.s.executeQuery(str);
//                display_room_table.setModel(DbUtils.resultSetToTableModel(result));
//            }
//            catch (Exception e)
//            {
//                System.out.println("Unable to Load Data. ");
//            }

        }
        else if(actionEvent.getSource() == go_back_button)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
