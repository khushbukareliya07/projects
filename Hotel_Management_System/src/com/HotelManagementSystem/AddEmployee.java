package com.HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField t_name, t_age, t_salary, t_phone, t_email;
    JRadioButton male, female;
    JComboBox job_dropdown;
    JButton submit_button;

    AddEmployee()
    {
        // ***** Name *****
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60,30,120,30);
        add(name);

        t_name = new JTextField();
        t_name.setBounds(200,30,150,30);
        add(t_name);

        //***** Age *****
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age.setBounds(60,80,120,30);
        add(age);

        t_age = new JTextField();
        t_age.setBounds(200,80,150,30);
        add(t_age);

        //***** Gender ***** [Radio buttons]
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setBounds(60,130,123,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.PLAIN, 16));
        male.setBounds(200,130,70,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.PLAIN, 16));
        female.setBounds(280,130,80,30);
        female.setBackground(Color.WHITE);
        add(female);


        //***** job ***** [Combo Box]
        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setBounds(60,180,120,30);
        add(job);

        String str[] = {"Manager","Front Desk", "Accountant", "Room Service", "Waiter/Waitress", "house Keeping",  "Kitchen Staff", "Chef"};
        job_dropdown = new JComboBox(str);
        job_dropdown.setBounds(200,180,150,30);
        job_dropdown.setBackground(Color.WHITE);
        add(job_dropdown);


        //***** salary *****
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary.setBounds(60,230,120,30);
        add(salary);

        t_salary = new JTextField();
        t_salary.setBounds(200,230,150,30);
        add(t_salary);

        //***** email *****
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60,280,120,30);
        add(email);

        t_email = new JTextField();
        t_email.setBounds(200,280,150,30);
        add(t_email);


        //***** phone *****
        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone.setBounds(60,330,120,30);
        add(phone);

        t_phone = new JTextField();
        t_phone.setBounds(200,330,150,30);
        add(t_phone);

        // Submit Button Config
        submit_button = new JButton("SUBMIT");
        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        submit_button.setBounds(210,400,120,30);
        submit_button.addActionListener(this);
        add(submit_button);



        //Right Side Part : Adding title "Add Employee Details"
        JLabel title_label = new JLabel("ADD EMPLOYEE DETAILS");
        title_label.setForeground(Color.black);
        title_label.setBounds(410,40,400,30);
        title_label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        add(title_label);


        //Adding Image
        ImageIcon employee_temp_image = new ImageIcon(ClassLoader.getSystemResource("com/HotelManagementSystem/icons/tenth.jpg"));
        Image scaledImage = employee_temp_image.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon final_employee_image = new ImageIcon(scaledImage);
        JLabel image_label = new JLabel(final_employee_image);
        image_label.setBounds(380,60,450,450);
        add(image_label);



        //Default Layout Config
        getContentPane().setBackground(Color.WHITE); //setting entire screen background!
        setLayout(null);
        setBounds(550,200,850,530);;
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = t_name.getText();
        String age = t_age.getText();
        String email = t_email.getText();
        String phone = t_phone.getText();
        String salary = t_salary.getText();

        //Getting gender Data
        String gender = null;
        if(male.isSelected())
        {
            gender = "male";
        }
        else if (female.isSelected())
        {
            gender = "female";
        }

        //Getting Job Data from Drop Down.
        String job = (String)job_dropdown.getSelectedItem();



        //Establishing Connection with DB and Inserting what we get from users.
        ConnectionConfig conn = new ConnectionConfig();
        String str = "INSERT into EMPLOYEE values ('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+email+"', '"+phone+"')";

        try
        {
            //directly executing query here
            conn.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New Employee Details added.");
            this.setVisible(false);
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }

}