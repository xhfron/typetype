package ui;


import dao.History;
import ui.widget.MyPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//主界面暂定使用Border Layout
public class UIFrame extends  JFrame {
    public UIFrame(MyPanel panel){
        super("打字游戏");
        setSize(880,600);
        setLocation(100,50);
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
