package AddressBook;

import javax.swing.*;

public class AlterAndAdd {
    JFrame window = new JFrame();
    JLabel label = new JLabel();

    AlterAndAdd(int i){
        if(i==0){
            label.setText("添加成功");
            label.setBounds(80,60,100,30);
        }
         else if(i==1){
             label.setText("修改成功");
             label.setBounds(80,60,100,30);
        }
         else if(i==2){
             label.setText("学号(工号)和电话必须为数字");
             label.setBounds(50,60,200,30);
        }
         else if(i==3){
             label.setText("该学号(工号)已存在");
             label.setBounds(60,60,200,30);
        }
         else if(i==4){
            label.setText("不可修改学号(工号)");
            label.setBounds(60,60,200,30);
        }
        window.add(label);
        window.setSize(250,200);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
