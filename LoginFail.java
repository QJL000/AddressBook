package AddressBook;

import javax.swing.*;
import java.awt.*;

public class LoginFail {
    JFrame window = new JFrame("登录错误");
    JLabel label = new JLabel("账号或密码错误");

    LoginFail(){
        label.setBounds(75,60,100,30);
        window.add(label);
        window.setSize(250,200);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
