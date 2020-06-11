import Item.Passage;
import ui.Test;
import ui.UIFrame;


import javax.swing.text.BadLocationException;

public class Main {
    static public void main(String[] args) throws BadLocationException {
//      History.load();
        new UIFrame(new Test(new Passage("1","asdhja hkjlka ewin fasi faij fdj")));
//        new UIFrame(new StartUI());
    }
}