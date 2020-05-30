package ui.event;

import java.util.EventObject;

public class FinishEvent extends EventObject {
    String input;//全部文本用于错误单词分析

    public FinishEvent(Object source,String input) {
        super(source);
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
