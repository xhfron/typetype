import Item.Passage;
import ui.Test;
import ui.UIFrame;


import javax.swing.text.BadLocationException;

public class Main {
    static public void main(String[] args) throws BadLocationException {
//      History.load();
        new UIFrame(new Test(new Passage("1","The drawString method does not handle new-lines. You'll have to split the string on new-line characters yourself and draw the lines one by one with a proper ")));
//        new UIFrame(new StartUI());
    }
}