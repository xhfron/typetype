package controller;

import ui.model.MyTargetModel;
import ui.model.StatusModel;
import ui.util.ColorFactory;
import ui.util.FontFactory;
import ui.view.StatusBar;
import ui.view.TargetPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StageController {
    private StatusModel statusModel;
    private MyTargetModel targetModel;
    private TargetPanel targetPanel;
    private StatusBar statusBar;
    private KeyAdapter inputKeyAdapter;
    private boolean running;

    public StageController(StatusModel statusModel, MyTargetModel targetModel, TargetPanel targetPanel, StatusBar statusBar) {
        this.statusModel = statusModel;
        this.targetModel = targetModel;
        this.targetPanel = targetPanel;
        this.statusBar = statusBar;
        inputKeyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                updateByInput(e.getKeyChar());

            }
        };
        statusBar.addKeyListener(inputKeyAdapter);

        running = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(running){
                    updatePosition();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    void updateByInput(char input) {
        targetModel.dealKey(input);
        statusModel.setRes(targetModel.isRight());
        statusModel.completeWord(targetModel.isComplete());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                statusBar.getIcon().setIcon(new ImageIcon(new ImageIcon(statusModel.getIconPath())
                        .getImage().
                                getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                statusBar.getProgressBar().setValue(statusModel.getProgress());
            }
        });

        if (statusModel.isEnd()) {
            running = false;
            statusBar.removeKeyListener(inputKeyAdapter);
        }
    }

    void updatePosition() {
        targetModel.refresh();
        if (targetModel.isFail()) {
            running = false;
            return;
        }
        targetPanel.setTargets(targetModel.getTargetQueue());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                targetPanel.repaint();
            }
        });


    }

}
