package ui;

import bean.Passage;
import dao.PassageData;
import ui.component.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PassageChooser extends JFrame {
    public PassageChooser() {
        super("文章选择");
        setSize(300,400);
        setContentPane(new MyPanel());
        PassageData.getData().forEach(e->{
            add(getItem(e));
        });
        setLocation(600,400);
        setVisible(true);
    }
    private JLabel getItem(Passage passage){


        JLabel label = new JLabel("    "+passage.getTitle());
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new UIFrame(new TypingUI(passage));
                setVisible(false);
            }
        });
        label.setFont(TextStyle.getInputFont());
        label.setPreferredSize(new Dimension(300,30));
        label.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.lightGray));

        return label;
    }
}
