package ui.view;

import Item.Passage;
import ui.model.MyTargetModel;
import ui.model.StatusModel;
import ui.widget.MyPanel;

import java.awt.*;

public class Stage extends MyPanel {
    private MyTargetModel targetModel;
    private StatusModel statusModel;
    public Stage(Passage passage) {
        statusModel = new StatusModel();

        targetModel = new MyTargetModel(passage,statusModel);
        StatusBar statusBar = new StatusBar(targetModel);
        statusModel.setStatusBar(statusBar);
        setLayout(new BorderLayout());
        add(new TargetPanel(targetModel), BorderLayout.CENTER);
        add(statusBar,BorderLayout.SOUTH);
    }
}
