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
    public StatusBar() {
        icon = new JLabel();
        icon.setPreferredSize(new Dimension(100,100));
        progressBar = new JProgressBar();
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(icon);
        add(progressBar);
        setFocusable(true);
    }

    public JLabel getIcon() {
        return icon;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }
}
