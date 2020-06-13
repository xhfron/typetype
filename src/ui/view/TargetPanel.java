package ui.view;

import Item.Passage;
import ui.model.MyTargetModel;
import ui.model.WordModel;
import ui.util.ColorFactory;
import ui.util.FontFactory;
import ui.widget.MyPanel;

import java.awt.*;
import java.util.Queue;

public class TargetPanel extends MyPanel{
    public void setTargets(Queue<WordModel> targets) {
        this.targets = targets;
    }

    private Queue<WordModel> targets;
    TargetPanel(MyTargetModel modelControl) {
        setPreferredSize(new Dimension(800,600));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTargets(g);
    }

    private void drawTargets(Graphics g) {
        for(WordModel model:targets){
            g.setFont(FontFactory.getFont(model.getState()));
            g.setColor(ColorFactory.getColor(model.getState()));
            g.drawString(model.getWord(),model.getX(),model.getY());
        }
    }
}