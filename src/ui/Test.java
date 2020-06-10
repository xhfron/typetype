package ui;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel {
    JLabel label = new JLabel("word");
    public Test() {
        super();
        add(label);
        x=0;
        y=0;
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
    public void update(Graphics g) {
        super.paintComponent(g);
        g.translate(x,y);
    }
}
