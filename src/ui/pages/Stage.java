package ui.pages;

import Item.Passage;
import ui.Controller;
import ui.listener.InputListener;
import ui.widget.MyPanel;
import ui.widget.Player;

import javax.swing.*;
import java.awt.*;

public class Stage extends MyPanel {
    JPanel wordPanel;
    Player player;
    Controller controller;
    public Stage(Passage passage) {
        wordPanel = new JPanel();
        wordPanel.setPreferredSize(new Dimension(200,300));
        wordPanel.setBackground(Color.red);
        controller = new Controller(passage,this);
        player = new Player(controller);
//        setLayout(new BorderLayout());
//        add(wordPanel);
//        add(player,BorderLayout.SOUTH);
    }
}
