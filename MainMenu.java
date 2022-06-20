package AddressBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu {
    JFrame window = new JFrame("通讯录");
    JLabel l1 = new JLabel("用户名:");
    JLabel l2 = new JLabel("密码:");
    JTextField text = new JTextField();
    JPasswordField value = new JPasswordField();
    JButton button1 = new JButton("登录");
    JButton button2 = new JButton();
    public MainMenu(){
        setAll();
        winAdd();
        winInit();
    }
    void setAll(){
        l1.setBounds(20,30, 80,30);
        l2.setBounds(20,75, 80,30);
        text.setBounds(100,30, 100,30);
        value.setBounds(100,75,100,30);
        button1.setBounds(100,120, 80,30);
        button1.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         window.dispose();
                                         new AdminMenu();
                                     }
                                 }
        );
    }
    void winAdd(){
        window.add(value);
        window.add(l1);
        window.add(l2);
        window.add(text);
        window.add(button1);
    }
    void winInit(){
        window.setSize(300,250);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
