package ui.component;

import javax.swing.*;

public class StatusBar extends JPanel {
    Double speed;
    Double correctRate;
    String time;//need to update
    JLabel status;
    public StatusBar() {
        this.speed = 0d;
        this.correctRate = 0d;
        time = "00:00:00";
        status = new JLabel();
        updateStatus();
        this.add(status);
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getCorrectRate() {
        return correctRate;
    }

    public String getTime() {
        return time;
    }

    private void updateStatus() {
        status.setText(
                "速度:"+getSpeed()+ "正确率"+getCorrectRate()+"时间"+getTime()
        );
    }

}
