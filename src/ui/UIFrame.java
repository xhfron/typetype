package ui;

import bean.Passage;
import dao.Errorbook;
import dao.History;
import dao.Rank;
import ui.component.MyPanel;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//主界面暂定使用Border Layout
public class UIFrame extends  JFrame {
    JPanel panel;
    TypingUI typing;
    Passage passage;
    StatusBar statusBar;
    boolean flag = true;
    public UIFrame(MyPanel panel){
        super("打字游戏");
        setSize(800,600);
        setLocation(500,300);
        add(panel);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                History.save();
            }
        });
    }
}
