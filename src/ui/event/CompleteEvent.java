package ui.event;

import jdk.jfr.Event;

import java.util.EventObject;
//完成一行的事件，用于实现自动换行
public class CompleteEvent extends EventObject {
    private int lineNumber;
    public CompleteEvent(Object source,int lineNumber) {
        super(source);
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

}
