package ui.component;

import ui.TextStyle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;

public class OriginTextLine extends JTextPane {
    StyledDocument doc;
    String originText = "this is a line for test";

    public OriginTextLine() throws BadLocationException {
        doc = getStyledDocument();
        loadStyle(doc);
        setPreferredSize(new Dimension(750, 44));
        setBackground(new Color(230, 230, 244));
        doc.insertString(0, originText, getStyle("normal"));
        setEditable(false);
    }

    void loadStyle(StyledDocument doc) {
        doc.addStyle("normal", TextStyle.getNormalStyle());
        doc.addStyle("wrong", TextStyle.getWrongStyle());
    }

    public void insertNewLine(String word) {
        try {
            doc.insertString(2, "\n" + word, doc.getStyle("my style"));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public boolean check(String input) {
        System.out.println(input);
        System.out.println(originText);
        System.out.println("---------------");

        boolean correct = true;
        try {
            int index;
            doc.remove(0, doc.getLength());
            for (index = 0; index < input.length(); index++) {
                doc.insertString(index, String.valueOf(originText.charAt(index)),
                        (originText.charAt(index) != input.charAt(index)) ? getStyle("wrong") : getStyle("normal"));
                correct = correct==false?false:(originText.charAt(index) != input.charAt(index));
            }
            for (; index < originText.length(); index++) {
                doc.insertString(index, String.valueOf(originText.charAt(index)), getStyle("normal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return correct;
    }


}
