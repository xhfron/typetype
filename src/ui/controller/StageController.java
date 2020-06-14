package ui.controller;

import Item.RankItem;
import dao.Rank;
import ui.model.MyTargetModel;
import ui.model.StatusModel;
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
        updateTime();
        updatePosition();
    }

    private void updateTime() {
        new Thread(()->{
            while (running){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(statusModel.isEnd()||targetModel.isFail()){
                    running = false;
                    calc();
                    break;
                }
                statusModel.upSecond();
                System.out.println("时间++");
                SwingUtilities.invokeLater(() -> {
                    statusBar.getTime().setText("时间： "
                            + statusModel.getMinute() + ":" + statusModel.getSecond());
                    statusBar.getSpeed().setText("速度： "
                            + statusModel.getSpeed() + "KPM");
                });
            }
        }).start();
    }

    private void updateByInput(char input) {
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
                statusBar.getAccuracy().setText("准确率: " + statusModel.getAccuracy());
            }
        });

        if (!running || statusModel.isEnd()||targetModel.isFail()) {
            running = false;
            statusBar.removeKeyListener(inputKeyAdapter);
            calc();
        }
    }

    private void updatePosition() {
        new Thread(()->{
            while(running){
                if (statusModel.isEnd()||targetModel.isFail()) {
                    running = false;
                    calc();
                    break;
                }
                targetModel.refresh();
                targetPanel.setTargets(targetModel.getTargetQueue());
                SwingUtilities.invokeLater(() -> targetPanel.repaint());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void calc() {
        Rank.addItem(statusModel.getRank());
        JOptionPane.showMessageDialog(targetPanel,targetModel.isFail()?"Game Over!":"You Win!");
    }

}
