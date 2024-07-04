package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.util.*;
public class SignupThree extends JFrame implements  ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JLabel cardnumber,pin;

    JButton submit,cancel;
    String formno;
    SignupThree(String formno){

        this.formno = formno;
        setLayout(null);
        JLabel a1 = new JLabel("PAGE 3: ACCOUNT DETAILS");
        a1.setBounds(280,40,400,40);
        a1.setBackground(Color.white);
        a1.setFont(new Font("Raleway",Font.BOLD,22));
        add(a1);

        JLabel AccountType= new JLabel(" ACCOUNT TYPE:");
        AccountType.setBounds(100,140,200,30);

        AccountType.setFont(new Font("Raleway",Font.BOLD,20));
        add(AccountType);

        r1 = new JRadioButton("SAVING ACCOUNT");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,250,20);
        r1.setBackground(Color.white);
        add(r1);
        r2 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,250,20);
        r2.setBackground(Color.white);
        add(r2);
        r3 = new JRadioButton("CURRENT ACCOUNT");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        r3.setBackground(Color.white);
        add(r3);
        r4 = new JRadioButton("RECCURING ACCOUNT");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        r4.setBackground(Color.white);
        add(r4);
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("CARD NUMBER");
        card.setBounds(100,300,200,30);
        card.setBackground(Color.white);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);
        JLabel carddetail = new JLabel("YOUR 16 DIGID CARD NUMBER");
        carddetail.setBounds(100,330,300,20);
        carddetail.setBackground(Color.white);
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(carddetail);
        cardnumber = new JLabel("XXXX-XXXX-XXXX-4567");
        cardnumber.setBounds(330,300,300,30);
        cardnumber.setBackground(Color.white);
        cardnumber.setFont(new Font("Raleway",Font.BOLD,22));
        add(cardnumber);
        pin = new JLabel("PIN");
        pin.setBounds(100,370,200,30);
        pin.setBackground(Color.white);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);

        pin = new JLabel("XXXX");
        pin.setBounds(330,370,300,30);
        pin.setBackground(Color.white);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        JLabel pinDETAIL = new JLabel("YOUR 4 DIGIT PASSWORD");
        pinDETAIL.setBounds(100,400,300,20);
        pinDETAIL.setBackground(Color.white);
        pinDETAIL.setFont(new Font("Raleway",Font.BOLD,12));
        add(pinDETAIL);

        JLabel service = new JLabel("SERICE REQUIRED:");
        service.setBounds(100,450,400,30);
        service.setBackground(Color.white);
        service.setFont(new Font("Raleway",Font.BOLD,22));
        add(service);


        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(350,550,200,30);
        add(c3);
        c4 = new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(100,550,200,30);
        add(c4);
        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7= new JCheckBox("HEREBY DECLARES THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,800,30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);







        getContentPane().setBackground(Color.WHITE);
        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String AccountType = null;
            if (r1.isSelected()) {

                AccountType ="SAVING ACCOUNT";
            }else if (r2.isSelected()){
                AccountType = "FIXED DIPOSIT ACCOUNT";
            }else if (r3.isSelected()){
                AccountType = "CURRENT ACCOUNT";
            }else if (r2.isSelected()){
                AccountType = "RECCURING ACCOUNT";
            }
            Random random = new Random();
            String  cardnumber = ""+Math.abs((random.nextLong()%90000000)+504093600000000L);
            String pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility+"ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility+"INTERNET BANKING";
            }else if (c3.isSelected()) {
                facility = facility+"MOBILE BANKING";
            }else if (c4.isSelected()) {
                facility = facility+"EMAIL & SMS ALERT";
            }else if (c5.isSelected()) {
                facility = facility+"CHEQUE BOOK";
            }else if (c6.isSelected()) {
                facility = facility+"E-STATEMENT";
            }
            try{
                if(AccountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }else {
                    Conn conn = new Conn();
                    String query1 = "insert into Signupthree values('"+formno+"','"+AccountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null, "cardnumber:"+ cardnumber +"\npin:"+pinnumber);

                }
                setVisible(false);
                new Deposit("pinnumber").setVisible(false);
            }catch (Exception ex){
                System.out.println(ex);

            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }
    }
    public static void main(String[] args) {
        new SignupThree("");

    }




}
