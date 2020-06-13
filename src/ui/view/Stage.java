package ui.view;

import Item.Passage;
import controller.StageController;
import ui.model.MyTargetModel;
import ui.model.StatusModel;
import ui.model.TargetModel;
import ui.widget.MyPanel;

import java.awt.*;

public class Stage extends MyPanel {
    private StatusModel statusModel;
    private MyTargetModel targetModel;
    private TargetPanel targetPanel;
    private StatusBar statusBar;
    private StageController controller;
    public Stage(Passage passage) {
        statusModel = new StatusModel(passage.getTotalWord());
        targetModel = new MyTargetModel(passage);
        statusBar = new StatusBar();
        targetPanel = new TargetPanel(targetModel);
        controller = new StageController(statusModel,targetModel,targetPanel,statusBar);
        setLayout(new BorderLayout());
        add(targetPanel,BorderLayout.CENTER);
        add(statusBar,BorderLayout.SOUTH);
    }
}
