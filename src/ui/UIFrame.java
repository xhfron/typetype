package ui;

import bean.Passage;
import ui.component.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//主界面暂定使用Border Layout
public class UIFrame extends  JFrame {
    JPanel panel;
    TypingUI typing;
    Passage passage;
    StatusBar statusBar;
    boolean flag = true;
    public UIFrame() throws BadLocationException {
        super("打字游戏");
        setSize(800,600);
        setLocation(500,300);
        passage = new Passage();
        passage.setContent("sasasasasasa");
        typing = new TypingUI(passage);
        JButton jButton = new JButton("aaaaaaaaaa");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setContentPane(typing);
            }
        });
        add(jButton);
        setVisible(true);
    }
}
