package ui;

import ui.component.MyButton;
import ui.component.TimerUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusBar extends JPanel {
    TimerUI timer;
    JButton pause;
    boolean timerFlag = true;
    JLabel status;
    double progress;
    public StatusBar() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        timer = new TimerUI();
        pause = new MyButton("暂停");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.setPause(timerFlag);
                timerFlag = !timerFlag;
                if(timerFlag)
                    pause.setText("继续");
                else
                    pause.setText("暂停");
            }
        });
        status = new JLabel("typing");
        status.setVisible(false);
        add(timer);
        add(pause);
        add(status);
    }

    public int getTime() {
        return timer.getSecond();
    }

    public void updateStatus(int speed,double correctRate) {
        status.setText("正确率"+String.format("%.2f",correctRate*100)+"%"+"速度"+speed+"KPM");
        status.setVisible(true);
    }

    public int stop(){
        timer.setPause(true);
        pause.setEnabled(false);
        pause.setText("结束");
        return getTime();
    }

}
