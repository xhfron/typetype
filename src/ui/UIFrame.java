package ui;

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
        OriginTextLine line =  new OriginTextLine();
        JButton button = new JButton("add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                line.insertNewLine("wa hahahaha");
                try {
                    line.checkInput('a');
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(line);
        panel.add(button);
//        statusBar = new StatusBar();
//        panel.add(statusBar);
        getContentPane().add(panel);
        setVisible(true);
    }

}
