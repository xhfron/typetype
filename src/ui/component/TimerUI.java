package ui.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerUI extends JLabel {
    int minute;
    int second;
    public TimerUI() {
        setText("111111111");
        minute = 0;
        second = 0;
        new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yes");
                second ++;
                if(second == 60){
                    minute++;
                    second = 0;
                }
                setText(minute+":"+second);
            }
        }).start();
    }
}
