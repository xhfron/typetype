package ui.event;

import jdk.jfr.Event;

import java.util.EventObject;

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
