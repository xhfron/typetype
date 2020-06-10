package ui.component;

import ui.TextStyle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;

public class OriginTextLine extends JTextPane {
    private StyledDocument doc;
    private String originText;

    public OriginTextLine(String originText) throws BadLocationException {
        doc = getStyledDocument();
        loadStyle(doc);
        setPreferredSize(new Dimension(750, 44));
        setBackground(TextStyle.getOriginTextBackground());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.originText = originText;
        hideText();
        setEditable(false);
    }

    public void hideText(){
        try{
            doc.remove(0, doc.getLength());
            doc.insertString(0, originText, getStyle("invisible"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showText() {
        try{
            doc.remove(0, doc.getLength());
            doc.insertString(0, originText, getStyle("normal"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    void loadStyle(StyledDocument doc) {
        doc.addStyle("normal", TextStyle.getNormalStyle());
        doc.addStyle("wrong", TextStyle.getWrongStyle());
        doc.addStyle("invisible",TextStyle.getInvisibleStyle());
    }


    public boolean check(String input) {
        boolean correct = true;
        try {
            int index;
            doc.remove(0, doc.getLength());
            for (index = 0; index < Math.min(input.length(),originText.length()); index++) {
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

    public int getLength(){
        return originText.length();
    }

}
