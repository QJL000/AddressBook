package AddressBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AdminMenu{
    JFrame window = new JFrame("通讯录");

    JPanel main = new JPanel();
    JPanel search = new JPanel();
    JPanel add = new JPanel();
    public AdminMenu(){
        winInit();
        setMain();
        add();
        Search();
        window.add(add);
        add.setVisible(false);
    }

    void winInit(){
        window.setSize(1050,600);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setMain(){
        main.setBounds(10,10,1010,40);
        main.setBorder(new LineBorder(Color.PINK));
        main.setLayout(null);
        JTextField text = new JTextField();
        JButton button1 = new JButton("查找");
        JButton button2 = new JButton("添加");
        JButton button3 = new JButton("修改");
        JButton button4 = new JButton("删除");
        button1.setBounds(560,6,80,30);
        button2.setBounds(650,6,80,30);
        button3.setBounds(740,6,80,30);
        button4.setBounds(830,6,80,30);
        text.setBounds(350,6,200,30);
//        text.setPreferredSize(new Dimension(200,30));
//        text.setLocation(350,10);
        button1.addActionListener((e -> {
            add.setVisible(false);
            search.setVisible(true);
        }));
        button2.addActionListener(e -> {
            search.setVisible(false);
            add.setVisible(true);
        });
        main.add(text);
        main.add(button1);
        main.add(button2);
        main.add(button3);
        main.add(button4);
        window.add(main);
    }

        void Search(){
        search.setBounds(10,55,1010,500);
        search.setBorder(new LineBorder(Color.BLUE));
        String[][] n = {{"1","2","3","4","5","6","7"}};
        String[] column = {"学号(工号)","姓名","性别","类型","电话","家庭住址","邮箱"};
        JTable table = new JTable(n,column);
        table.setLocation(15,55);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 470));
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(250);
        table.getColumnModel().getColumn(6).setPreferredWidth(170);
        JScrollPane scrollPane = new JScrollPane(table);
        //table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        search.add(scrollPane);
        window.add(search);
    }


    void add(){
        add.setBounds(10,55,1010,500);
        add.setBorder(new LineBorder(Color.GRAY));
        add.setLayout(null);
        JLabel l1 = new JLabel("学号(工号)");
        JLabel l2 = new JLabel("姓名");
        JLabel l3 = new JLabel("性别");
        JLabel l4 = new JLabel("类型");
        JLabel l5 = new JLabel("电话");
        JLabel l6 = new JLabel("家庭住址");
        JLabel l7 = new JLabel("邮箱");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JComboBox<String> c1 = new JComboBox<>(new String[] {"男","女"});
        JComboBox<String> c2 = new JComboBox<>(new String[] {"学生","教师"});
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JButton b1 = new JButton("确定添加");
        JButton b2 = new JButton("重置");
        l1.setBounds(300,20,80,40);
        l2.setBounds(340,70,80,40);
        l3.setBounds(340,120,80,40);
        l4.setBounds(340,170,80,40);
        l5.setBounds(340,220,80,40);
        l6.setBounds(310,270,80,40);
        l7.setBounds(340,320,80,40);
        l1.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l2.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l3.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l4.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l5.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l6.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l7.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        t1.setBounds(400,20,400,40);
        t2.setBounds(400,70,400,40);
        c1.setBounds(400,120,400,40);
        c2.setBounds(400,170,400,40);
        t3.setBounds(400,220,400,40);
        t4.setBounds(400,270,400,40);
        t5.setBounds(400,320,400,40);
        b1.setBounds(390,400,100,40);
        b2.setBounds(650,400,100,40);
        b1.addActionListener(e -> {
            File fp = new File("information.txt");
            try {
                FileWriter writer = new FileWriter(fp,true);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    
                }
            }
            String no = t1.getSelectedText();
            String name = t2.getSelectedText();
            String sex = (String) c1.getSelectedItem();
            String type = (String) c2.getSelectedItem();
            String telenum = t3.getSelectedText();
            String address = t4.getSelectedText();
            String email = t5.getSelectedText();


        });
        b2.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            c1.setSelectedItem("男");
            c2.setSelectedItem("学生");

        });
        add.add(l1);
        add.add(l2);
        add.add(l3);
        add.add(l4);
        add.add(l5);
        add.add(l6);
        add.add(l7);
        add.add(t1);
        add.add(t2);
        add.add(t3);
        add.add(t4);
        add.add(t5);
        add.add(c1);
        add.add(c2);
        add.add(b1);
        add.add(b2);
        window.add(add);
    }
}