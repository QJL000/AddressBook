package AddressBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class UserMenu {
    JFrame window = new JFrame("通讯录");
    JPanel main = new JPanel();
    JPanel search = new JPanel();

    public UserMenu(){
        ArrayList<Person> list = Person.getInformation();
        main.setBounds(10,10,1010,40);
        main.setLayout(null);
        JTextField text = new JTextField();
        JButton button1 = new JButton("查找");
        button1.setBounds(560,6,80,30);
        text.setBounds(350,6,200,30);
        main.add(text);
        main.add(button1);
        window.add(main);

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
        }));

        window.setSize(1050,600);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
