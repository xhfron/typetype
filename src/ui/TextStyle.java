package ui;

import javax.naming.Context;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.*;
import java.awt.*;

public class TextStyle {
    public static Color getOriginTextBackground(){
        return new Color(230, 230, 244);
    }
    public static Font getRankFont(){
        return new Font("黑体",Font.PLAIN,20);
    }
    public static Style getNormalStyle(){
        Style style = StyleContext.getDefaultStyleContext().addStyle(
                "normal",
                StyleContext.getDefaultStyleContext().getStyle(
                        StyleContext.DEFAULT_STYLE
                )
        );
        StyleConstants.setFontSize(style,28);
        StyleConstants.setFontFamily(style,"Consolas");
        return style;
    }
    public static Style getWrongStyle(){
        Style style = StyleContext.getDefaultStyleContext().addStyle(
                "wrong",
                getNormalStyle()
        );
        StyleConstants.setForeground(style,Color.red);
        return style;
    }
    public static Font getInputFont(){
        return new Font("Consolas",Font.PLAIN,28);
    }

    public static Font getTitleFont() {
        return new Font("黑体",Font.PLAIN,40);
    }

    public static Style getInvisibleStyle() {
        Style style = getNormalStyle();
        StyleConstants.setForeground(style,getOriginTextBackground());
        return style;
    }
}
