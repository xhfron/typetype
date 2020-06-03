package ui.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerUI extends JLabel {
    int minute;
    int second;
    Timer timer;
    public TimerUI() {
        minute = 0;
        second = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second ++;
                if(second == 60){
                    minute++;
                    second = 0;
                }
                setText(minute+":"+second);
            }
        });
        timer.start();
    }

    public void setPause(boolean status){
        if(status){
            timer.stop();
        }else{
            timer.start();
        }
    }

    public int getSecond(){
        return minute*60+second;
    }
}
