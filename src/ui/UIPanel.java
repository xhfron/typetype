package ui;

import javax.swing.*;

public class UIPanel {
    JFrame frame;
    JPanel panel;
    StatusBar statusBar;
    public UIPanel(){
        frame = new JFrame("打字游戏");
        frame.setSize(800,600);
        panel = new JPanel();
        statusBar = new StatusBar();
        panel.add(statusBar);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }


}
