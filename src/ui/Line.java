package ui;

import bean.Passage;
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

public class Line extends JPanel {
    private OriginTextLine originTextLine;
    private InputLine inputLine;
    private BoxLayout boxLayout;
    private int lineNumber;
    private LineCompleteListener listener;
    boolean pause = false;
    public Line(int lineNumber, String originText) {
        this.lineNumber = lineNumber;
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setBackground(null);
        setOpaque(false);
        setLayout(boxLayout);
        setBorder(new LineBorder(new Color(211, 238, 244), 2, true));
        setPreferredSize(new Dimension(750, 100));
        try {
            originTextLine = new OriginTextLine(originText);
            inputLine = new InputLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(originTextLine);
        add(Box.createVerticalStrut(12));
        add(inputLine);
    }

    void addLineCompleteListener(LineCompleteListener listener) {
        this.listener = listener;
    }

    void lineComplete() {
        if (listener != null) {
            listener.nextLine(new CompleteEvent(this, lineNumber));
        }
    }

    public void active() {
        inputLine.setEditable(true);
        inputLine.requestFocus();
        originTextLine.showText();
        inputLine.addCaretListener(e -> {
            if(pause) return;
            String inputString = inputLine.getText();
            originTextLine.check(inputLine.getText());
            if (inputString.length() >= originTextLine.getLength()) {
                lineComplete();
                return;
            }
        });
    }

    void stop() {
        inputLine.setEnabled(false);
    }

    void pause() {
        inputLine.setEditable(false);
        originTextLine.hideText();
        pause = true;
    }

    void resume() {
        inputLine.setEditable(true);
        originTextLine.showText();
        pause =false;
    }

    String getInput() {
        return inputLine.getText();
    }
}
