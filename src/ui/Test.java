package ui;

import ui.widget.MyPanel;

import javax.swing.*;
import java.awt.*;

public class Test extends MyPanel {
    JLabel label = new JLabel("word");
    public Test() {
        super();
        add(label);
        x=-100;
        y=00;
        JButton t = new JButton("11");
        t.addActionListener(e->{
            x+=10;
            y+=10;
            repaint();
        });
        add(t);
    }
    int x;
    int y;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(x,y);
    }
}
