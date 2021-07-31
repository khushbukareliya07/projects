package com.HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar menu; // mb
    JMenu hm_menu, admin_menu; //m1,m2
    JMenuItem add_reception, add_employee, add_rooms, add_drivers; //i1, i2, i3, i4

    Dashboard()
    {
        menu = new JMenuBar();
        add(menu);

        hm_menu = new JMenu("Hotel Management");
        hm_menu.setForeground(Color.RED);
        hm_menu.setFont(new Font("Serif",  Font.ITALIC, 20));
        menu.add(hm_menu);

        admin_menu = new JMenu("Admin");
        admin_menu.setForeground(Color.RED);
        admin_menu.setFont(new Font("Serif", Font.ITALIC, 20));
        menu.add(admin_menu);

        //Adding Items into the Drop Down Menu

        add_reception = new JMenuItem("RECEPTION");
        add_reception.setFont(new Font("Serif", Font.ITALIC, 15));
        add_reception.addActionListener(this);
        hm_menu.add(add_reception);

        add_employee = new JMenuItem("ADD EMPLOYEE");
        add_employee.setFont(new Font("Serif", Font.ITALIC, 15));
        add_employee.addActionListener(this);
        admin_menu.add(add_employee);

        add_rooms = new JMenuItem("ADD ROOMS");
        add_rooms.setFont(new Font("Serif", Font.ITALIC, 15));
        add_rooms.addActionListener(this);
        admin_menu.add(add_rooms);

        add_drivers = new JMenuItem("ADD DRIVERS");
        add_drivers.setFont(new Font("Serif", Font.ITALIC, 15));
        add_drivers.addActionListener(this);
        admin_menu.add(add_drivers);


        menu.setBounds(0,0,1950,50);
        ImageIcon  dashboard_temp_image = new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/dashboard.jpg"));
        Image dashboard_scaled_image = dashboard_temp_image.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon dashboard_final_image = new ImageIcon(dashboard_scaled_image);
        JLabel dashboard_image_label = new JLabel(dashboard_final_image);
        dashboard_image_label.setBounds(0,0,1950,1000);
        add(dashboard_image_label);


        //title on the page
        JLabel title_label = new JLabel("ROYAL GROUP WELCOMES YOU!");
        title_label.setBounds(600,80,1000,50);
        title_label.setForeground(Color.WHITE);
        title_label.setFont(new Font("Tahoma", Font.PLAIN, 50));
        dashboard_image_label.add(title_label);

        setLayout(null);
        setBounds(0,0,1950,1000);
        setVisible(true);

    }

    public static void main(String[] args) {
    new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getActionCommand().equals("RECEPTION"))
        {
            new Reception().setVisible(true);
        }
        else if(actionEvent.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee().setVisible(true);
        }
        else if(actionEvent.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRooms().setVisible(true);
        }
    }
}
