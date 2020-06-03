package ui;

import bean.Passage;
import dao.History;
import ui.component.MyPanel;
import ui.event.FinishEvent;
import ui.listener.PassageFinishListener;
import javax.swing.*;
import java.awt.*;


public class TypingUI extends MyPanel {
    Passage passage;
    Pages page;
    StatusBar statusBar;
    PassageFinishListener finishListener;
    public TypingUI(Passage passage) {
        this.passage = passage;
        setSize(800,600);
//        setLayout(new BorderLayout());

        page = new Pages(passage.getContent());
        page.addFinishListener(
                finishListener = new PassageFinishListener() {
                    @Override
                    public void settle(FinishEvent event) {
                        dealFinish(event.getInput());
                    }
                }
        );
        statusBar = new StatusBar();

        add(page,BorderLayout.CENTER);
        add(statusBar,BorderLayout.SOUTH);

//        add(page,BorderLayout.CENTER);
//        add(statusBar,BorderLayout.SOUTH);
//        add(Box.createHorizontalStrut(8),BorderLayout.EAST);
//        add(Box.createHorizontalStrut(8),BorderLayout.WEST);
    }

    private void dealFinish(String input) {
        int cost = statusBar.stop();
        int count = 0;
        for(int i=0;i<passage.getContent().length();i++){
            if(input.charAt(i)!=passage.getContent().charAt(i)){
                continue;
            }
            count++;
        }
        statusBar.updateStatus(60*input.length()/cost,count*1.0/input.length());
        History.analyze(passage,input,60*input.length()/cost,count*1.0/input.length());
    }
}
