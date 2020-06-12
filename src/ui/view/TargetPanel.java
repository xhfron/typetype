package ui.view;

import Item.Passage;
import ui.model.MyTargetModel;
import ui.model.TargetModel;
import ui.util.ColorFactory;
import ui.util.FontFactory;
import ui.widget.MyPanel;

import java.awt.*;

public class TargetPanel extends MyPanel implements Runnable{
    private MyTargetModel modelControl;
    TargetPanel(MyTargetModel modelControl) {
        this.modelControl = modelControl;
        setPreferredSize(new Dimension(800,600));
        new Thread(modelControl).start();
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTargets(g);
    }

    private void drawTargets(Graphics g) {
        for(TargetModel model:modelControl.getTargetQueue()){
            g.setFont(FontFactory.getFont(model.getState()));
            g.setColor(ColorFactory.getColor(model.getState()));
            g.drawString(model.getWord(),model.getX(),model.getY());
        }
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
