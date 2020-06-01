package ui.component;

import dao.Rank;
import ui.TextStyle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RankList extends JList {
    private List items;
    public RankList() {
        items = new ArrayList<>();
        load();
        setListData(items.toArray());
        setFont(TextStyle.getRankFont());
        setOpaque(false);
        setBackground(null);
    }

    private void load() {
        Rank.getRanks().forEach(e->{
            items.add(e.toString());
        });
    }
}
