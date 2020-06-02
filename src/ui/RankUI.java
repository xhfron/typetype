package ui;

import bean.RankItem;
import dao.Rank;
import org.w3c.dom.Text;
import ui.component.MyButton;
import ui.component.MyPanel;
import ui.component.RankList;

import javax.swing.*;
import javax.xml.validation.Validator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankUI extends MyPanel{
    private RankList ranklist;
    private JPanel container;
    private JLabel title;
    private int count = 0;
    private final  int limit = 8;
    private MyButton deleteButton;
    public RankUI() {
        setSize(800,600);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(200));
        container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container.setBackground(null);
        container.setOpaque(false);
        container.setAlignmentY(BoxLayout.X_AXIS);
        add(container);
        init();
    }

    private void init(){
        container.add(Box.createVerticalStrut(20));
        title = new JLabel("Rank");
        title.setFont(TextStyle.getTitleFont());
        title.setForeground(Color.pink);
        container.add(title);
        container.add(Box.createVerticalStrut(20));
        Rank.getRanks().forEach(e->{
            if(count<limit){
                container.add(getItem(e));
                container.add(Box.createVerticalStrut(8));
            }
        });
        deleteButton = new MyButton("删除历史");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rank.clear();
                JOptionPane.showMessageDialog(container,"删除历史！");
                container.repaint();
            }
        });
        container.add(deleteButton);
    }

    private JLabel getItem(RankItem itemData) {
        count++;
        JLabel item = new JLabel(""+count+"  "+
                itemData.toString());
        item.setFont(TextStyle.getRankFont());
        item.setForeground(Color.white);
        return item;
    }
}
