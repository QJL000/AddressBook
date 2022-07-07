package AddressBook;

import javax.swing.*;

public class LoginAndRegister {
    JFrame window = new JFrame();
    JLabel label = new JLabel();

    LoginAndRegister(int i){
        if(i==0){
            label.setText("密码错误");
        }
        else if(i==1){
            label.setText("该用户名不存在");
        }
        else if(i==2){
            label.setText("用户名或密码错误");
        }
        else if(i==3){
            label.setText("该用户名已存在");
        }
        else if(i==4){
            label.setText("用户名不得为空");
        }
        else if(i==5){
            label.setText("注册成功");
        }
        label.setBounds(75,60,100,30);
        window.add(label);
        window.setSize(250,200);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
