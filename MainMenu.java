package AddressBook;

import java.awt.*;
import javax.swing.*;

public class MainMenu {
    JFrame window1 = new JFrame("通讯录");
    Container con = window1.getContentPane();
    JLabel l1=new JLabel("用户名:");
    JLabel l2=new JLabel("密码:");
    JTextField text = new JTextField();
    JPasswordField value = new JPasswordField();
    JButton button = new JButton("登录");
    public MainMenu(){
        setAll();
        winAdd();
        winInit();
    }
    void setAll(){
        l1.setBounds(20,20, 80,30);
        l2.setBounds(20,75, 80,30);
        text.setBounds(100,20, 100,30);
        value.setBounds(100,75,100,30);
        button.setBounds(100,120, 80,30);
    }
    void winAdd(){
        window1.add(value);
        window1.add(l1);
        window1.add(l2);
        window1.add(text);
        window1.add(button);
    }
    void winInit(){
        con.setBackground(Color.white);
        window1.setSize(300,300);
        window1.setLocationRelativeTo(null);
        window1.setLayout(null);
        window1.setVisible(true);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
