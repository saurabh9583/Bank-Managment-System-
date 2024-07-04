package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);

        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20240526T141943Z-001/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);

        add(label);
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,20));
        cardno.setBounds(120,150,250,50);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(120,220,250,40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220,230,30);
        add(pinTextField);

         login = new JButton("LOG IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


         signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,500);
        setVisible(true);
        setLocation(350,200  );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource()==login){
            Conn conn = new Conn();
            String cardnumber =cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query3 = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query3);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                }

            }catch( Exception ae){
                System.out.println(ae);
            }


        }else if(e.getSource()==signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }


    public static void main(String[] args) {

        new Login();
    }



}


