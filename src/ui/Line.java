package ui;

import ui.component.InputLine;
import ui.component.OriginTextLine;
import ui.event.CompleteEvent;
import ui.listener.LineCompleteListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.util.EventListener;

public class Line extends JPanel{
    private OriginTextLine originTextLine;
    private InputLine inputLine;
    private BoxLayout boxLayout;
    private int lineNumber;
    private LineCompleteListener listener;

    public Line(int lineNumber) {
        this.lineNumber = lineNumber;
        boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setBackground(null);
        setOpaque(false);
        setLayout(boxLayout);
        setBorder(new LineBorder(new Color(211, 238, 244),2,true));
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
                String inputString  = inputLine.getText();
                if(inputString.length()>=originTextLine.getLength()){
                    lineComplete();
                    return;
                }
                originTextLine.check(inputLine.getText());
            }
        });
    }

    void addLineCompleteListener(LineCompleteListener listener){
        this.listener = listener;
    }

    void lineComplete(){
        if(listener!=null){
            listener.nextLine(new CompleteEvent(this,lineNumber));
        }
    }

    public void getFocus() {
        inputLine.requestFocus();
    }
}
