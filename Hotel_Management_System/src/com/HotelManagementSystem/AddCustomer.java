//Development In progress

package com.HotelManagementSystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    JTextField t_number, t_name,t_country,t3,t4;
    JComboBox ID_combobox; //combobox and choice works same  just the difference is they belong to different package. Jcombobox - swing, choice- awt
    Choice c2;
    JRadioButton radioButton_male, radioButton_female,r2;

    AddCustomer()
    {

        JLabel title_customer_form =  new JLabel("NEW CUSTOMER FORM");
        title_customer_form.setBounds(100,20,350,30);
        title_customer_form.setForeground(Color.BLUE);
        title_customer_form.setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 20));
        add(title_customer_form);

        JLabel customer_ID =  new JLabel("ID");
        customer_ID.setBounds(35,80,100,20);
//        customer_ID.setForeground(Color.BLUE);
        add(customer_ID);

        ID_combobox = new JComboBox(new String[] {"Driving License", "State ID", "Passport"} );
        ID_combobox.setBounds(200,80,150,25);
        ID_combobox.setBackground(Color.WHITE);
        add(ID_combobox);

        JLabel customer_name_label =  new JLabel("Name");
        customer_name_label.setBounds(35,120,100,20);
//        customer_name.setForeground(Color.BLUE);
        add(customer_name_label);

        t_name = new JTextField();
        t_name.setBounds(200,120,150,25);
        add(t_name);

        JLabel customer_number_label =  new JLabel("Number");
        customer_number_label.setBounds(35,160,100,20);
//        customer_number.setForeground(Color.BLUE);
        add(customer_number_label);

        t_number = new JTextField();
        t_number.setBounds(200,160,150,25);
        add(t_number);

        JLabel customer_gender_label =  new JLabel("Gender");
        customer_gender_label.setBounds(35,200,100,20);
//        customer_gender.setForeground(Color.BLUE);
        add(customer_gender_label);

        radioButton_male = new JRadioButton("Male");
        radioButton_male.setBackground(Color.WHITE);
        radioButton_male.setBounds(200,200,60,25);
        add(radioButton_male);

        radioButton_female = new JRadioButton("Female");
        radioButton_female.setBackground(Color.WHITE);
        radioButton_female.setBounds(270,200,80,25);
        add(radioButton_female);

        JLabel country_label =  new JLabel("Country");
        country_label.setBounds(35,240,100,20);
//        country.setForeground(Color.BLUE);
        add(country_label);

        t_country = new JTextField();
        t_country.setBounds(200,240,150,25);
        add(t_country);

        JLabel allocated_room_label =  new JLabel("Allocated Room Number");
        allocated_room_label.setBounds(35,280,150,20);
//        allocated_room.setForeground(Color.BLUE);
        add(allocated_room_label);

        JLabel check_in_data_label =  new JLabel("Checked In");
        check_in_data_label.setBounds(35,320,100,20);
//        check_in_data.setForeground(Color.BLUE);
        add(check_in_data_label);

        JLabel Deposit =  new JLabel("Deposit");
        Deposit.setBounds(35,360,100,20);
//        Deposit.setForeground(Color.BLUE);
        add(Deposit);

        //Defult Configuration
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0,1950,1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }






}
