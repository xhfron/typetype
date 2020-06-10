package ui;

import dao.Errorbook;
import ui.component.MyButton;
import ui.component.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ErrorBookUI extends MyPanel{
    private JPanel container;
    private int count = 0;
    private final  int limit = 8;
    private JPanel words;
    ErrorBookUI() {
        setSize(800,600);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(20));
        container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container.setBackground(null);
        container.setOpaque(false);
        container.setAlignmentY(BoxLayout.X_AXIS);
        add(container);
        init();
    }

    private void init(){
        words = new MyPanel();
        words.setBackground(null);
        words.setOpaque(true);
        words.setPreferredSize(new Dimension(100,200));
        words.setAlignmentX(FlowLayout.LEFT);
        container.add(Box.createVerticalStrut(20));
        JLabel title = new JLabel("易错单词");
        title.setFont(TextStyle.getTitleFont());
        title.setForeground(Color.pink);
        container.setAlignmentX(Box.CENTER_ALIGNMENT);
        container.add(title);
        container.add(Box.createVerticalStrut(20));
        container.add(words);

        Errorbook.getMap().forEach((k,v)->{
            if(count<limit){
                System.out.println(k+"  "+v);
                words.add(getItem(k,v));
                words.add(Box.createVerticalStrut(8));
            }
        });
        MyButton deleteButton = new MyButton("删除历史");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Errorbook.clear();
                JOptionPane.showMessageDialog(container,"删除历史！");
                container.repaint();
            }
        });
        container.add(deleteButton);
        container.add(Box.createVerticalStrut(20));
    }

    private JLabel getItem(String word,int fre) {
        count++;
        JLabel item = new JLabel(word+" "+fre);
        item.setFont(TextStyle.getRankFont());
        item.setForeground(Color.white);
        item.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        return item;
    }
}

