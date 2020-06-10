package ui.pages;

import ui.listener.InputListener;
import ui.widget.Player;

import javax.swing.*;
import java.awt.*;

public class Stage extends JPanel {
    JPanel wordPanel;
    Player player;
    public Stage(InputListener listener) {
        player = new Player(listener);
        wordPanel = new JPanel();
        setLayout(new BorderLayout());
        add(wordPanel,BorderLayout.CENTER);
        add(player,BorderLayout.SOUTH);
    }
}
