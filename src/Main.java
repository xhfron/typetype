import ui.Test;
import ui.UIFrame;
import ui.pages.StartUI;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.TextAction;

public class Main {
    static public void main(String[] args) throws BadLocationException {
//      History.load();
//        new UIFrame(new Test());
        new UIFrame(new StartUI());
    }
}