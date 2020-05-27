package ui.component;

import ui.TextStyle;

import javax.swing.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.awt.*;


public class InputLine extends JTextField {
    StyledDocument doc;
    public InputLine() throws BadLocationException {
        setPreferredSize(new Dimension(750, 44));
        setFont(TextStyle.getInputFont());

    }

}
