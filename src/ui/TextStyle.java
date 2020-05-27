package ui;

import javax.naming.Context;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextStyle {
    public static Style getNormalStyle(){
        Style style = StyleContext.getDefaultStyleContext().addStyle(
                "normal",
                StyleContext.getDefaultStyleContext().getStyle(
                        StyleContext.DEFAULT_STYLE
                )
        );
        StyleConstants.setFontSize(style,28);
        StyleConstants.setFontFamily(style,"微软雅黑");
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
        return new Font("微软雅黑",Font.PLAIN,28);
    }

}
