package ui.component;

import ui.TextStyle;

import javax.swing.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class InputLine extends JTextField {
    StyledDocument doc;
    public InputLine(){
        setPreferredSize(new Dimension(750, 44));
        setFont(TextStyle.getInputFont());
        setEditable(false);
    }

}
