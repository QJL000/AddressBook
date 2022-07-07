package AddressBook;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainMenu {
    ArrayList<String[]> list = getInformation();
    JFrame window = new JFrame("通讯录");
    JLabel l1 = new JLabel("用户名:");
    JLabel l2 = new JLabel("密码:");
    JTextField text = new JTextField();
    JPasswordField value = new JPasswordField();
    JButton button1 = new JButton("登录");
    JButton button2 = new JButton("注册");
    JButton button3 = new JButton("管理员登录");
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
        button1.setBounds(50,120, 80,30);
        button2.setBounds(140,120, 80,30);
        button3.setBounds(85,160, 100,30);
        button1.addActionListener(e -> {
            String zhanghao = text.getText();
            String mima = new String(value.getPassword());
            int flag = 0;
            for(String[] s:list){
                if(s[0].equals(zhanghao)){
                    flag = 1;
                    if(s[1].equals(mima)){
                        window.dispose();
                        new UserMenu();
                    }
                    else{
                        new LoginAndRegister(0);
                    }
                }
            }
            if(flag==0){
                new LoginAndRegister(1);
            }
        });
        button2.addActionListener(e -> {
            String zhanghao = text.getText();
            String mima = new String(value.getPassword());
            if(zhanghao.trim().equals("")){
                new LoginAndRegister(4);
            }
            else{
                int flag = 0;
                for(String[] s:list){
                    if(s[0].equals(zhanghao)){
                        flag = 1;
                        new LoginAndRegister(3);
                        break;
                    }
                }
                if(flag==0){
                    list.add(new String[]{zhanghao,mima});
                    saveRegister(zhanghao,mima);
                    new LoginAndRegister(5);
                }
            }
        });
        button3.addActionListener(e -> {
            String zhanghao = text.getText();
            String mima = new String(value.getPassword());
            if(zhanghao.equals("root") && mima.equals("root")) {
                window.dispose();
                new AdminMenu();
            }
            else {
                new LoginAndRegister(2);
            }
        });
    }
    void winAdd(){
        window.add(value);
        window.add(l1);
        window.add(l2);
        window.add(text);
        window.add(button1);
        window.add(button2);
        window.add(button3);
    }
    void winInit(){
        window.setSize(300,250);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static ArrayList<String[]> getInformation() {
        ArrayList<String[]> list = new ArrayList<>();
        File fp = new File("User.txt");
        if(!fp.exists()) {
            try {
                fp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileReader inOne = new FileReader(fp)){
            BufferedReader inTwo = new BufferedReader(inOne);
            String[] s;
            String n;
            while((n=inTwo.readLine())!=null){
                s = n.split(" ");
                list.add(new String[]{s[0],s[1]});
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void saveRegister(String m,String n){
        try(FileWriter writer = new FileWriter("User.txt",true)){
            writer.write(m + " " + n + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

