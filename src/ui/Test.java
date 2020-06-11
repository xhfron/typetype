package ui;

import Item.Passage;
import ui.model.MyTargetModel;
import ui.model.TargetModel;
import ui.widget.MyPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test extends MyPanel implements Runnable{
    MyTargetModel modelControl;
    public Test(Passage passage) {
        setPreferredSize(new Dimension(800,600));
        modelControl = new MyTargetModel(passage);
//        new Thread(modelControl).start();
//        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTargets(g);
    }

    private void drawTargets(Graphics g) {
        for(TargetModel model:modelControl.getTargetQueue()){
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
