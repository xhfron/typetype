package ui;

import bean.Passage;
import dao.Errorbook;
import dao.History;
import dao.Rank;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//主界面暂定使用Border Layout
public class UIFrame extends  JFrame {
    JPanel panel;
    TypingUI typing;
    Passage passage;
    StatusBar statusBar;
    boolean flag = true;
    public UIFrame() throws BadLocationException {
        super("打字游戏");
        setSize(800,600);
        setLocation(500,300);
        passage = new Passage();
        passage.setContent("This Is Us is an American family comedy drama television series on September 20, 2016."
                );
        typing = new TypingUI(passage);
        JButton jButton = new JButton("aaaaaaaaaa");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setContentPane(typing);
            }
        });
        add(new RankUI());
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                History.save();
                System.out.println("out trigger");
            }
        });
    }
}
