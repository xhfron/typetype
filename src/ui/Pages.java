package ui;

import ui.event.CompleteEvent;
import ui.listener.LineCompleteListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Pages extends JPanel{
    List<Line> lines;
    public Pages() {
        BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        Line line2 = new Line(2);
        setLayout(boxLayout);
        setOpaque(false);
        //debug
            Line line = new Line(1);
            line.addLineCompleteListener(new LineCompleteListener() {
                @Override
                public void nextLine(CompleteEvent event) {
                    System.out.println(event.getLineNumber());
                    line2.getFocus();
                }
            });

        line2.addLineCompleteListener(new LineCompleteListener() {
            @Override
            public void nextLine(CompleteEvent event) {
                System.out.println(event.getLineNumber());
            }
        });
        add(line);
        add(Box.createVerticalStrut(8));
            add(line2);
        //debug
    }

}
