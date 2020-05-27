package ui;

import ui.component.InputLine;
import ui.component.OriginTextLine;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.util.EventListener;

public class Line extends JPanel implements EventListener {
    private OriginTextLine originTextLine;
    private InputLine inputLine;
    private BoxLayout boxLayout;
    private int lineNumber;
    public Line(int lineNumber) {
        this.lineNumber = lineNumber;
        boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setBackground(null);
        setOpaque(false);
        setLayout(boxLayout);
        setBorder(new LineBorder(Color.pink,4,true));
        setSize(750,100);
        try{
            originTextLine = new OriginTextLine();
            inputLine = new InputLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        add(originTextLine);
        add(Box.createVerticalStrut(12));
        add(inputLine);
        inputLine.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                originTextLine.check(inputLine.getText());
            }
        });
    }
}
