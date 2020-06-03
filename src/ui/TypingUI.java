package ui;

import bean.Passage;
import dao.History;
import ui.component.MyPanel;
import ui.event.FinishEvent;
import ui.listener.PassageFinishListener;
import ui.listener.PauseListener;

import javax.swing.*;
import java.awt.*;


public class TypingUI extends MyPanel {
    Passage passage;
    Pages page;
    StatusBar statusBar;
    PassageFinishListener finishListener;
    PauseListener pauseListener;
    public TypingUI(Passage passage) {
        this.passage = passage;
        setSize(800,600);

        page = new Pages(passage.getContent());
        page.addFinishListener(
                finishListener = event -> dealFinish(event.getInput())
        );
        pauseListener = pause -> page.dealPause(pause);
        statusBar = new StatusBar(pauseListener);

        add(page,BorderLayout.CENTER);
        add(statusBar,BorderLayout.SOUTH);
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
