package ui.event;

import java.util.EventObject;

public class PauseEvent extends EventObject {
    boolean flag;
    public PauseEvent(Object source,boolean flag) {
        super(source);
        this.flag = flag;
    }
    boolean isPause(){
        return flag;
    }
}
