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

public class SignupTwo extends JFrame implements ActionListener {

    JTextField CATEGORYJTextField, RELIGIONJTextField, INCOMEJTextField, EDUCATION_CLASSIFICATIONJTextField, OCCUPATIONJTextField, PAN_NUMBERJTextField, AADHAR_NUMBERJTextField;
    JRadioButton EYES, ENO,SYES,SNO;
    JComboBox valRELIGION,Category,valINCOME,VAL_EDUACTION,OCCUPATION_CHOICE;
    String formno;
    JButton next;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);



        JLabel personalDetails = new JLabel("Page 2 : ADDITIONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 80, 500, 30);
        add(personalDetails);

        JLabel RELIGION = new JLabel("RELIGION :");
        RELIGION.setFont(new Font("Raleway", Font.BOLD, 20));
        RELIGION.setBounds(100, 130, 100, 40);
        add(RELIGION);

        String RELIGION_type[] ={"HINDU","MUSLIM","SIKH","CHRISTIAN"};
        valRELIGION = new JComboBox(RELIGION_type);
//        valRELIGION.setFont(new Font("Raleway", Font.BOLD, 20));
        valRELIGION.setBounds(300, 130, 400, 40);
        add(valRELIGION);

        JLabel CATEGORY = new JLabel("CATEGORY :");
        CATEGORY.setFont(new Font("Raleway", Font.BOLD, 20));
        CATEGORY.setBounds(100, 190, 200, 40);
        add(CATEGORY);

        String Category_type[] = {"SC","ST","GENERAL","OBC"};
        Category = new JComboBox(Category_type);
//        Category.setFont(new Font("Raleway", Font.BOLD, 20));
        Category.setBounds(300, 190, 400, 40);
        add(Category);

        JLabel INCOME = new JLabel("INCOME :");
        INCOME.setFont(new Font("Raleway", Font.BOLD, 20));
        INCOME.setBounds(100, 250, 100, 40);
        add(INCOME);

        String INCOME_TYPE[] ={"NULL","< 1,50,000","< 2,50,000","<500000","<1000000"};
        valINCOME = new JComboBox(INCOME_TYPE);
//        valRELIGION.setFont(new Font("Raleway", Font.BOLD, 20));
        valINCOME.setBounds(300, 250, 400, 40);
        add(valINCOME);

        JLabel SENIOR_CITIZEN = new JLabel("SENIOR_CITIZEN");
        SENIOR_CITIZEN.setFont(new Font("Raleway", Font.BOLD, 20));
        SENIOR_CITIZEN.setBounds(100, 310, 200, 40);
        add(SENIOR_CITIZEN);

        SYES = new JRadioButton("YES");
        SYES.setBounds(300, 310, 60, 40);
        SYES.setBackground(Color.white);
        add(SYES);

        SNO = new JRadioButton("NO");
        SNO.setBounds(450, 310, 120, 40);
        SNO.setBackground(Color.white);
        add(SNO);

        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(SYES);
        gendergrp.add(SNO);

        JLabel EXISTION_ACCOUNT = new JLabel("EXISTION_ACCOUNT");
        EXISTION_ACCOUNT.setFont(new Font("Raleway", Font.BOLD, 20));
        EXISTION_ACCOUNT.setBounds(100, 370, 200, 40);
        add(EXISTION_ACCOUNT);

        EYES = new JRadioButton("YES");
        EYES.setBounds(300, 370, 60, 40);
        EYES.setBackground(Color.white);
        add(EYES);

        ENO = new JRadioButton("NO");
        ENO.setBounds(450, 370, 120, 40);
        ENO.setBackground(Color.white);
        add(ENO);
        ButtonGroup ACC_grp = new ButtonGroup();
        ACC_grp.add(EYES);
        ACC_grp.add(ENO);



        JLabel EDUCATION_CLASSIFICATION = new JLabel("EDUCATION :");
        EDUCATION_CLASSIFICATION.setFont(new Font("Raleway", Font.BOLD, 20));
        EDUCATION_CLASSIFICATION.setBounds(100, 430, 200, 40);
        add(EDUCATION_CLASSIFICATION);
        String EDUCATION_type[] = {"NON-GRADUATE","GRADUATE","POST GRADUATE","OTHERS"};
        VAL_EDUACTION = new JComboBox(EDUCATION_type);
        VAL_EDUACTION.setBounds(300, 430, 400, 40);
        add(VAL_EDUACTION);

        JLabel OCCUPATION = new JLabel("OCCUPATION :");
        OCCUPATION.setFont(new Font("Raleway", Font.BOLD, 20));
        OCCUPATION.setBounds(100, 490, 200, 40);
        add(OCCUPATION);
        String OCCUPATION_VAL[] = {"SALARIED","SELF EMPLOYEED","BUSSINESS","STUDENT","RETIRED","OTHERS"};
        OCCUPATION_CHOICE = new JComboBox(OCCUPATION_VAL);
        OCCUPATION_CHOICE.setBounds(300, 490, 400, 40);
        add(OCCUPATION_CHOICE);

        JLabel PAN_NUMBER = new JLabel("PAN_NUMBER :");
        PAN_NUMBER.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN_NUMBER.setBounds(100, 550, 200, 40);
        add(PAN_NUMBER);
        PAN_NUMBERJTextField = new JTextField();
        PAN_NUMBERJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN_NUMBERJTextField.setBounds(300, 550, 400, 40);
        add(PAN_NUMBERJTextField);

        JLabel AADHAR_NUMBER = new JLabel("AADHAR_NUMBER :");
        AADHAR_NUMBER.setFont(new Font("Raleway", Font.BOLD, 20));
        AADHAR_NUMBER.setBounds(100, 610, 200, 40);
        add(AADHAR_NUMBER);
        AADHAR_NUMBERJTextField = new JTextField();
        AADHAR_NUMBERJTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        AADHAR_NUMBERJTextField.setBounds(300, 610, 400, 40);
        add(AADHAR_NUMBERJTextField);



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
        String religion = (String)valRELIGION.getSelectedItem();
        String category = (String)Category.getSelectedItem();
        String income = (String)valINCOME.getSelectedItem();

        String senior_citizen = null;
        if (SYES.isSelected()) {
            senior_citizen = "YES";
        } else if (SNO.isSelected()) {
            senior_citizen = "NO";
        }

        String existion_account = null;
        if (EYES.isSelected()) {
            existion_account = "YES";
        } else if (ENO.isSelected()) {
            existion_account = "NO";
        }
        String eduction = (String)VAL_EDUACTION.getSelectedItem();
        String occupation = (String)OCCUPATION_CHOICE.getSelectedItem();
        String aadhar = AADHAR_NUMBERJTextField.getText();
        String pan = PAN_NUMBERJTextField.getText();
        String query = "INSERT INTO signupTwo VALUES('" + formno + "', '" + religion + "', '" + category + "','" + income + "', '" + senior_citizen + "', '" + existion_account + "', '" + eduction + "', '" + occupation + "', '" + aadhar + "', '" + pan + "')";

        try {
            if (religion.equals("")) {
                JOptionPane.showMessageDialog(null, "proper detail is required");
            } else {
                Conn c = new Conn();

                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);

            }

        }catch (Exception e1){
            e1.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}


