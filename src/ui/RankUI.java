package ui;

import dao.Rank;
import ui.component.MyPanel;
import ui.component.RankList;

import javax.swing.*;
import javax.xml.validation.Validator;
import java.awt.*;

public class RankUI extends MyPanel{
    private RankList ranklist;
    public RankUI() {
        setSize(800,600);
        JLabel jLabel = new JLabel(Rank.getRanks().get(0).toString());
        jLabel.setPreferredSize(new Dimension(700,50));
        add(jLabel);

        add(new JLabel("1"));

    }
}
