package ui.util;

import java.awt.*;

public class FontFactory {
    public static Font getFont(WordState state){
        if(state==WordState.SELECT){
            return new Font("Arial",Font.BOLD,30);
        }
        return new Font("Arial",Font.PLAIN,28);
    }
    public static Font getFont(String name){
        switch (name){
            case "title":
                return new Font("Arial",Font.BOLD,30);
            default:
                return new Font("微软雅黑",Font.PLAIN,20);
        }
    }
}
