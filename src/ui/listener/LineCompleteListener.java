package ui.listener;

import ui.event.CompleteEvent;

import java.util.EventListener;

public interface LineCompleteListener extends EventListener {
    void nextLine(CompleteEvent event);
}
