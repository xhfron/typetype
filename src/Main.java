import ui.Test;


import javax.swing.*;
import javax.swing.text.BadLocationException;

public class Main {
    static public void main(String[] args) throws BadLocationException {
//        History.load();
        JFrame frame = new JFrame("i");
        frame.setSize(1000,800);
        frame.setContentPane(new Test());
        frame.setVisible(true);
    }
}