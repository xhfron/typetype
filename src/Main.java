import bean.RankItem;
import dao.Errorbook;
import dao.History;
import dao.Rank;
import ui.UIFrame;

import javax.swing.text.BadLocationException;

public class Main {
    static public void main(String[] args) throws BadLocationException {
        History.load();
        UIFrame LoginUi = new UIFrame();
    }
}