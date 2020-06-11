package ui.util;

import java.awt.*;

public class ColorFactory {
    public static Color getColor(WordState state){
        switch (state){
            case DONE:
                return Color.green;
            case SELECT:
                return Color.red;
            case NORMAL:
                return Color.white;
        }
        return Color.blue;
    }
}
