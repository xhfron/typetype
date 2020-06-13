package ui.view;

import ui.UIFrame;
import ui.util.FontFactory;
import ui.widget.MyPanel;

import javax.swing.*;
import java.awt.*;

public class StartUI extends MyPanel {
    private JLabel title;
    private Box menuBox;
    private JButton typing;
    private JButton rank;
    private JButton errorBook;

    public StartUI() {
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        menuBox = Box.createVerticalBox();
        title = new JLabel("打字游戏");
        init();
        add(Box.createHorizontalStrut(100));
        add(title);
        add(Box.createHorizontalStrut(200));
        add(menuBox);
    }

    private void init() {
        typing = new JButton("开始练习");
        typing.addActionListener(e -> new PassageChooser());
        rank = new JButton("排行榜");
        rank.addActionListener(e -> new UIFrame(new RankUI()));
        errorBook = new JButton("易错记录");
        errorBook.addActionListener(e -> new UIFrame(new ErrorBookUI()));
        menuBox.add(typing);
        menuBox.add(Box.createVerticalStrut(8));
        menuBox.add(rank);
        menuBox.add(Box.createVerticalStrut(8));
        menuBox.add(errorBook);
    }
}
