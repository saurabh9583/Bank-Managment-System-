package bank.managment.system;
import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    JButton amount1,amount2,amount3,amount4,amount5,amount6,Back;
    String pinnumber;

    fastCash(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20240526T141943Z-001/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT:");
        text.setBounds(215,270,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));

        image.add(text);

        amount1 = new JButton("Rs 100");
        amount1.setBounds(170,415,150,30);
        amount1.addActionListener(this);
        image.add(amount1);

        amount2 = new JButton("Rs 200");
        amount2.setBounds(355,415,150,30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3 = new JButton("Rs 500");
        amount3.setBounds(170,450,150,30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4 = new JButton("Rs 1000");
        amount4.setBounds(355,450,150,30);
        amount4.addActionListener(this);
        image.add(amount4);

        amount5 = new JButton("Rs 5000");
            amount5.setBounds(170,485,150,30);
        amount5.addActionListener(this);
        image.add(amount5);

        amount6 = new JButton("Rs 10000");
        amount6.setBounds(355,485,150,30);
        amount6.addActionListener(this);
        image.add(amount6);

        Back = new JButton("Back");
        Back.setBounds(355,520,150,30);
        Back.addActionListener(this);
        image.add(Back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }else {

            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs =c.s.executeQuery("select*from Bank where pinnumber = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-= Integer.parseInt(rs.getString("amount"));

                    }

                }
                if(e.getSource()!=Back  && balance < Integer.parseInt(amount) ){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");

                }else{
                    Date date = new Date();
                    String query = "insert into Bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited succesfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch(Exception ae){
                System.out.println(ae);
            }
        }

    }
    public static void main(String[] args) {

        new fastCash("");
    }



}
