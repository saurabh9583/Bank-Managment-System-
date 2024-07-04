package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField fnameJTextField, nameJTextField, ageJTextField, emailJTextField, adressJTextField, STATEJTextField, PINJTextField, CITYJTextField;
    JRadioButton male, female;
    JDateChooser dateChooser;
    JButton next;

    SignupOne() {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 80, 500, 30);
        add(personalDetails);

        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 130, 100, 40);
        add(name);

        nameJTextField = new JTextField();
        nameJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        nameJTextField.setBounds(300, 130, 400, 40);
        add(nameJTextField);

        JLabel fname = new JLabel("FATHER NAME :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 40);
        add(fname);
        fnameJTextField = new JTextField();
        fnameJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        fnameJTextField.setBounds(300, 190, 400, 40);
        add(fnameJTextField);

        JLabel age = new JLabel("AGE :");
        age.setFont(new Font("Raleway", Font.BOLD, 20));
        age.setBounds(100, 250, 100, 40);
        add(age);
        ageJTextField = new JTextField();
        ageJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        ageJTextField.setBounds(300, 250, 400, 40);
        add(ageJTextField);

        JLabel GENDER = new JLabel("GENDER");
        GENDER.setFont(new Font("Raleway", Font.BOLD, 20));
        GENDER.setBounds(100, 310, 100, 40);
        add(GENDER);

        male = new JRadioButton("Male");
        male.setBounds(300, 310, 60, 40);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 310, 120, 40);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);

        JLabel DOB = new JLabel("DATE OF BIRTH :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 370, 200, 40);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 370, 100, 40);
        add(dateChooser);

        JLabel email = new JLabel("EMAIL :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 430, 200, 40);
        add(email);
        emailJTextField = new JTextField();
        emailJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        emailJTextField.setBounds(300, 430, 400, 40);
        add(emailJTextField);

        JLabel adress = new JLabel("ADRESS :");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100, 490, 200, 40);
        add(adress);
        adressJTextField = new JTextField();
        adressJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        adressJTextField.setBounds(300, 490, 400, 40);
        add(adressJTextField);

        JLabel STATE = new JLabel("STATE :");
        STATE.setFont(new Font("Raleway", Font.BOLD, 20));
        STATE.setBounds(100, 550, 200, 40);
        add(STATE);
        STATEJTextField = new JTextField();
        STATEJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        STATEJTextField.setBounds(300, 550, 400, 40);
        add(STATEJTextField);

        JLabel PIN = new JLabel("PIN :");
        PIN.setFont(new Font("Raleway", Font.BOLD, 20));
        PIN.setBounds(100, 610, 200, 40);
        add(PIN);
        PINJTextField = new JTextField();
        PINJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        PINJTextField.setBounds(300, 610, 400, 40);
        add(PINJTextField);

        JLabel CITY = new JLabel("CITY :");
        CITY.setFont(new Font("Raleway", Font.BOLD, 20));
        CITY.setBounds(100, 670, 200, 40);
        add(CITY);
        CITYJTextField = new JTextField();
        CITYJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        CITYJTextField.setBounds(300, 670, 400, 40);
        add(CITYJTextField);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 730, 80, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = nameJTextField.getText();
        String fname = fnameJTextField.getText();
        String email = emailJTextField.getText();
        String formno = "" + random; // random=long
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String GENDER = null;
        if (male.isSelected()) {
            GENDER = "MALE";
        } else if (female.isSelected()) {
            GENDER = "FEMALE";
        }
        String adress = adressJTextField.getText();
        String PIN = PINJTextField.getText();
        String STATE = STATEJTextField.getText();
        String CITY = CITYJTextField.getText();
        String query = "INSERT INTO signup VALUES('" + formno + "', '" + name + "', '" + fname + "', '" + GENDER + "', '" + DOB + "', '" + PIN + "', '" + CITY + "', '" + STATE + "', '" + adress + "', '" + email + "')";

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();

                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch (Exception e1){
            e1.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
}

