import dao.History;
import ui.UIFrame;
import ui.view.StartUI;


public class Main {
    static public void main(String[] args){
      History.load();
      new UIFrame(new StartUI());
    }
}