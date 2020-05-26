package ui.component;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isOpaque()) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gradientPaint =
                new GradientPaint(width/2, 0,new Color(131, 96, 195),
                        width/2, height, new Color(46, 191, 145),false);

        g2.setPaint(gradientPaint);
        g2.fillRect(0, 0, width, height);

    }
}

