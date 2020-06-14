package ui.view;

import Item.RankItem;
import dao.Rank;
import ui.util.FontFactory;
import ui.widget.MyPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankUI extends MyPanel {
    private JPanel container;
    private JLabel title;
    private int count = 0;
    private final  int limit = 8;
    private JButton deleteButton;

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
        title.setForeground(Color.pink);
        title.setFont(FontFactory.getFont("title"));
        container.add(title);
        container.add(Box.createVerticalStrut(20));
        Rank.getRanks().forEach(e->{
            if(count<limit){
                container.add(getItem(e));
                container.add(Box.createVerticalStrut(8));
            }
        });
        deleteButton = new JButton("删除历史");
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
        item.setFont(FontFactory.getFont("item"));
        item.setForeground(Color.white);
        return item;
    }
}
