package ui.view;

import ui.listener.InputListener;
import ui.model.StatusModel;
import ui.widget.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StatusBar extends MyPanel{
    private JLabel icon;
    private JProgressBar progressBar;
    private String iconPath;
    private int progress;
    public StatusBar(InputListener listener) {
        icon = new JLabel();
        icon.setPreferredSize(new Dimension(100,100));
        progressBar = new JProgressBar();
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(icon);
        add(progressBar);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                listener.dealKey(e.getKeyChar());
            }
        });
        setFocusable(true);
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        icon.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().
                getScaledInstance(20,20,Image.SCALE_DEFAULT)));
        progressBar.setValue(progress);
    }


}
