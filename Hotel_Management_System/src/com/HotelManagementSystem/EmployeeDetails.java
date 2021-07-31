package com.HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeDetails extends JFrame implements ActionListener
{
    JTable display_table;
    JButton b_loadData, b_back;

    EmployeeDetails()
    {
        display_table = new JTable();
        display_table.setBounds(5,50,1000,500);
        add(display_table);

        //Creating labels for Table Display
        JLabel name_label =  new JLabel("Name");
        name_label.setBounds(40,15,70,20);
        name_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(name_label);

        JLabel age_label =  new JLabel("Age");
        age_label.setBounds(185,15,70,20);
        age_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(age_label);

        JLabel gender_label =  new JLabel("Gender");
        gender_label.setBounds(320,15,70,20);
        gender_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(gender_label);

        JLabel role_label =  new JLabel("Department");
        role_label.setBounds(465,15,90,20);
        role_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(role_label);

        JLabel salary_label =  new JLabel("Salary");
        salary_label.setBounds(615,15,70,20);
        salary_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(salary_label);

        JLabel email_label =  new JLabel("Email");
        email_label.setBounds(745,15,70,20);
        email_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(email_label);

        JLabel contactNumber_label =  new JLabel("Contact");
        contactNumber_label.setBounds(885,15,70,20);
        contactNumber_label.setFont(new Font("Serif", Font.BOLD, 14));
        add(contactNumber_label);






        //Adding & Configuring buttons
        b_loadData =  new JButton("Load Data");
        b_loadData.setBounds(350,560,120,30);
        b_loadData.setBackground(Color.BLACK);
        b_loadData.setForeground(Color.white);
        b_loadData.addActionListener(this::actionPerformed);
        add(b_loadData);

        b_back =  new JButton("Back");
        b_back.setBounds(530,560,120,30);
        b_back.setBackground(Color.BLACK);
        b_back.setForeground(Color.WHITE);
        b_back.addActionListener(this::actionPerformed);
        add(b_back);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,200,1000,700);
        setVisible(true);

        showData();
    }
    public void showData() {
        try
        {
            ConnectionConfig conn = new ConnectionConfig();
            String str = "SELECT * FROM employee";

            ResultSet result = conn.s.executeQuery(str);
            display_table.setModel(DbUtils.resultSetToTableModel(result));

        }
        catch(Exception e)
        {
            System.out.println("Unable to Load Data.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b_loadData)
        {
            showData();
//            try
//            {
//                ConnectionConfig conn = new ConnectionConfig();
//                String str = "SELECT * FROM employee";
//
//                ResultSet result = conn.s.executeQuery(str);
//                display_table.setModel(DbUtils.resultSetToTableModel(result));
//
//            }
//            catch(Exception e)
//            {
//                System.out.println("Unable to Load Data.");
//            }

        }
        else if(actionEvent.getSource() == b_back)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EmployeeDetails().setVisible(true);

    }
}
