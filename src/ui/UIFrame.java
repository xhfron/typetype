package ui;

import ui.component.InputLine;
import ui.component.MyPanel;
import ui.component.OriginTextLine;
import ui.component.StatusBar;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIFrame extends  JFrame {
    JPanel panel;
    StatusBar statusBar;
    public UIFrame() throws BadLocationException {
        super("打字游戏");
        setSize(800,600);
        setLocation(500,300);
        panel = new MyPanel();
        panel.add(new Pages());
        getContentPane().add(panel);
        setVisible(true);
    }

}
