package AddressBook;

import javax.swing.*;

public class MyException {
    JFrame window = new JFrame("登录错误");
    JLabel label = new JLabel("请选择一行数据");

    MyException(){
        label.setBounds(75,60,100,30);
        window.add(label);
        window.setSize(250,200);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
