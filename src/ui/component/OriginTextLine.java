package ui.component;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class OriginTextLine extends JTextPane {
    StyledDocument doc;
    String originText = "this is a line for test";
    int index = 0;
    public OriginTextLine() throws BadLocationException {
        doc = getStyledDocument();
        Style s = doc.addStyle("my style",getStyle(StyleContext.DEFAULT_STYLE));
        Style red = doc.addStyle("wrong",s);
        StyleConstants.setFontSize(s,20);
        StyleConstants.setForeground(red, Color.red);
        doc.insertString(0,originText,s);
    }
    public void insertNewLine(String word){
        try {
            doc.insertString(2,"\n"+word,doc.getStyle("my style"));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void checkInput(char input) throws Exception {
        if(originText.charAt(index)!=input){
            doc.remove(index,1);
            doc.insertString(index,String.valueOf(originText.charAt(index)),getStyle("wrong"));
        }
    }


}
