package ui.model;

import java.awt.event.KeyEvent;

public class InputModel {
    boolean inputRight;
    int progress=0;

    public String getIconPath(){
        if(inputRight){
            return "resource/icon/right.png";
        }
        return "resource/icon/wrong.png";
    }

    public int getProgress(){
        return  progress++/1000;
    }

    public void dealKey(KeyEvent e) {
        inputRight = !inputRight;
    }
}
