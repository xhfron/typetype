package ui.listener;

import ui.event.CompleteEvent;

import java.util.EventListener;

public interface LineCompleteListener extends EventListener {
    public void nextLine(CompleteEvent event);
}
