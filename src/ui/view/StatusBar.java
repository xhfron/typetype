package ui.view;

import ui.model.InputModel;
import ui.widget.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StatusBar extends MyPanel implements Runnable {
    JLabel icon;
    InputModel model;
    JProgressBar progress;
    public StatusBar() {
        icon = new JLabel();
        icon.setPreferredSize(new Dimension(100,100));
        progress = new JProgressBar();
        model = new InputModel();
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(icon);
        add(progress);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                model.dealKey(e);
                System.out.println(e.getKeyChar());
            }
        });


        setFocusable(true);
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        icon.setIcon(new ImageIcon(new ImageIcon(model.getIconPath()).getImage().
                getScaledInstance(20,20,Image.SCALE_DEFAULT)));
        progress.setValue(model.getProgress());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
