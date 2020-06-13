package ui.view;

import ui.widget.MyPanel;

import javax.swing.*;
import java.awt.*;


public class StatusBar extends MyPanel{
    private JLabel icon;
    private JProgressBar progressBar;
    private JLabel speed;
    private JLabel accuracy;
    private JLabel time;

    public StatusBar() {
        icon = new JLabel();
        icon.setPreferredSize(new Dimension(100,100));
        progressBar = new JProgressBar();
        speed = new JLabel("速度: 0KPM");
        accuracy = new JLabel("准确率： 100%");
        time = new JLabel("时间： 0：0");
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(8));
        add(icon);
        Box rateBox = Box.createVerticalBox();
        rateBox.add(speed);
        rateBox.add(accuracy);
        add(time);
        add(Box.createHorizontalStrut(8));
        add(rateBox);
        add(Box.createHorizontalStrut(8));
        add(progressBar);
        add(Box.createHorizontalStrut(8));
        setFocusable(true);
    }

    public JLabel getIcon() {
        return icon;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JLabel getSpeed() {
        return speed;
    }

    public JLabel getAccuracy() {
        return accuracy;
    }

    public JLabel getTime() {
        return time;
    }
}
