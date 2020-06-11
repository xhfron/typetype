package ui.view;

import Item.Passage;
import ui.Test;
import ui.widget.MyPanel;

import java.awt.*;

public class Stage extends MyPanel {
    public Stage() {
        setLayout(new BorderLayout());
        add(new Test(new Passage("","")), BorderLayout.CENTER);
        add(new StatusBar(),BorderLayout.SOUTH);
    }
}
