package ui;

import bean.Passage;
import ui.component.MyButton;
import ui.component.MyPanel;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUI extends MyPanel {
    private JLabel title;
    private Box menuBox;
    private MyButton typing;
    private MyButton rank;
    private MyButton errorBook;

    public StartUI() {
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        menuBox = Box.createVerticalBox();
        title = new JLabel("打字游戏");
        title.setFont(TextStyle.getTitleFont());
        init();
        add(Box.createHorizontalStrut(100));
        add(title);
        add(Box.createHorizontalStrut(200));
        add(menuBox);
    }

    private void init() {
        typing = new MyButton("开始练习");
        typing.addActionListener(e -> new PassageChooser());
        rank = new MyButton("排行榜");
        rank.addActionListener(e -> new UIFrame(new RankUI()));
        errorBook = new MyButton("易错记录");
        errorBook.addActionListener(e -> new UIFrame(new ErrorBookUI()));
        menuBox.add(typing);
        menuBox.add(Box.createVerticalStrut(8));
        menuBox.add(rank);
        menuBox.add(Box.createVerticalStrut(8));
        menuBox.add(errorBook);
    }
}
