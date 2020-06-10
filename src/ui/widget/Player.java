package ui.widget;

import ui.listener.InputListener;

import javax.swing.*;

public class Player extends JPanel {
    private InputListener listener;
    public Player(InputListener listener) {
        this.listener = listener;
    }
}
