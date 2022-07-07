package AddressBook;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminMenu{
    JFrame window = new JFrame("通讯录");
    JPanel main = new JPanel();
    JPanel search = new JPanel();
    JPanel add = new JPanel();
    public AdminMenu(){
        ArrayList<Person> list = Person.getInformation();
        main.setBounds(10,10,1010,40);
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
        main.add(text);
        main.add(button1);
        main.add(button2);
        main.add(button3);
        main.add(button4);
        window.add(main);

//查找
        search.setBounds(10,55,1010,500);
        String[] column = {"学号(工号)","姓名","性别","类型","电话","家庭住址","邮箱"};
        JTable table = new JTable();
        AtomicReference<DefaultTableModel> model = new AtomicReference<>(new DefaultTableModel());
        model.get().setColumnIdentifiers(column);
        for(Person s:list){
            model.get().addRow(new String[]{s.getNo(),s.getName(),s.getSex(),s.getType(),s.getTelenum(),s.getaddress(),s.getEmail()});
        }
        table.setModel(model.get());
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
        search.add(scrollPane);
        window.add(search);


//修改和添加界面
        add.setBounds(10,55,1010,500);
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
        JButton b3 = new JButton("确认修改");
        l1.setBounds(250,20,80,40);
        l2.setBounds(290,70,80,40);
        l3.setBounds(290,120,80,40);
        l4.setBounds(290,170,80,40);
        l5.setBounds(290,220,80,40);
        l6.setBounds(260,270,80,40);
        l7.setBounds(290,320,80,40);
        l1.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l2.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l3.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l4.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l5.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l6.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        l7.setFont(new Font(Font.DIALOG, Font.BOLD,15));
        t1.setBounds(350,20,400,40);
        t2.setBounds(350,70,400,40);
        c1.setBounds(350,120,400,40);
        c2.setBounds(350,170,400,40);
        t3.setBounds(350,220,400,40);
        t4.setBounds(350,270,400,40);
        t5.setBounds(350,320,400,40);
        b1.setBounds(340,400,100,40);
        b2.setBounds(600,400,100,40);
        b3.setBounds(470,400,100,40);
        b1.addActionListener(e -> {
            String no = t1.getText();
            String name = t2.getText();
            String sex = (String) c1.getSelectedItem();
            String type = (String) c2.getSelectedItem();
            String telenum = t3.getText();
            String address = t4.getText();
            String email = t5.getText();
            if(isNumeric(no) && isNumeric(telenum)){
                if(!Person.find(list,no)){
                    if(no.trim().equals("")){
                        no="null";
                    }
                    if(name.trim().equals("")){
                        name="null";
                    }
                    if(telenum.trim().equals("")){
                        telenum="null";
                    }
                    if(address.trim().equals("")){
                        address="null";
                    }
                    if(email.trim().equals("")){
                        email="null";
                    }
                    list.add(new Person(no,name,sex,type,telenum,address,email));
                    model.get().addRow(new String[]{no,name,sex,type,telenum,address,email});
                    table.setModel(model.get());
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    c1.setSelectedItem("男");
                    c2.setSelectedItem("学生");
                    new AlterAndAdd(0);
                    add.setVisible(false);
                    search.setVisible(true);
                }
                else{
                    new AlterAndAdd(3);
                }
            }
            else{
                new AlterAndAdd(2);
            }
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
        b3.addActionListener(e -> {
            String[] s = new String[7];
            s[0] = t1.getText();
            s[1] = t2.getText();
            s[2] = (String) c1.getSelectedItem();
            s[3] = (String) c2.getSelectedItem();
            s[4] = t3.getText();
            s[5] = t4.getText();
            s[6] = t5.getText();
            if((isNumeric(s[0]) || s[0].equals("null")) && (isNumeric(s[4]) || s[4].equals("null"))){
                int row=table.getSelectedRow();
                if(table.getValueAt(row, 0).equals(s[0])){
                    for(int j=0;j<7;j++) {
                        if(s[j].trim().equals(""))
                            s[j]="null";
                        model.get().setValueAt(s[j],row,j);
                    }
                    for(Person ss:list){
                        if(ss.getNo().equals(s[0])){
                            ss.setNo(s[0]);
                            ss.setName(s[1]);
                            ss.setSex(s[2]);
                            ss.setType(s[3]);
                            ss.setTelenum(s[4]);
                            ss.setaddress(s[5]);
                            ss.setEmail(s[6]);
                        }
                    }
                    new AlterAndAdd(1);
                    add.setVisible(false);
                    search.setVisible(true);
                }
                else{
                    new AlterAndAdd(4);
                    t1.setText((String)table.getValueAt(row,0));
                }
            }
            else{
                new AlterAndAdd(2);
            }


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
        add.add(b3);
        window.add(add);


        button1.addActionListener((e -> {
            String ss=text.getText();
            model.get().getDataVector().clear();
            if(ss.trim().equals("")){
                for(Person s:list){
                    model.get().addRow(new String[]{s.getNo(),s.getName(),s.getSex(),s.getType(),s.getTelenum(),s.getaddress(),s.getEmail()});
                }
                table.setModel(model.get());
            }
            else{
                for(Person s:list){
                    if(s.getNo().equals(ss) || s.getName().equals(ss))
                        model.get().addRow(new String[]{s.getNo(),s.getName(),s.getSex(),s.getType(),s.getTelenum(),s.getaddress(),s.getEmail()});
                }
                table.setModel(model.get());
            }
            model.get().fireTableDataChanged();
            table.updateUI();
            add.setVisible(false);
            search.setVisible(true);
        }));
        button2.addActionListener(e -> {
            search.setVisible(false);
            add.setVisible(true);
            b3.setVisible(false);
            b2.setVisible(true);
            b1.setVisible(true);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            c1.setSelectedItem("男");
            c2.setSelectedItem("学生");
        });
        button3.addActionListener(e -> {
            try{
                int row=table.getSelectedRow();
                String[] str= new String[7];
                for(int j=0;j<7;j++) {
                    str[j]= (String) table.getValueAt(row, j);
                }
                t1.setText(str[0]);
                t2.setText(str[1]);
                t3.setText(str[4]);
                t4.setText(str[5]);
                t5.setText(str[6]);
                c1.setSelectedItem(str[2]);
                c2.setSelectedItem(str[3]);
                search.setVisible(false);
                add.setVisible(true);
                b3.setVisible(true);
                b1.setVisible(false);
                b2.setVisible(false);
            } catch (Exception ex) {
                new MyException();
            }
        });
        button4.addActionListener(e -> {
            try{
                int row=table.getSelectedRow();
                String str = (String)table.getValueAt(row, 0);
                model.get().removeRow(row);
                list.removeIf(ss -> ss.getNo().equals(str));
            } catch (Exception ex) {
                new MyException();
            }
        });

        add.setVisible(false);
        window.setSize(1050,600);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Person.savefile(list);
                System.exit(0);
            }
        });
        window.setVisible(true);
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}