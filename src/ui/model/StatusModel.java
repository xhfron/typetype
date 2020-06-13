package ui.model;

import ui.listener.CheckListener;
import ui.view.StatusBar;

public class StatusModel{
    private int totalWord;
    private int wordCount;
    private boolean res;

    public void setRes(boolean res) {
        this.res = res;
    }
    public void completeWord(boolean complete){
        if(complete){
            wordCount++;
        }
    }

    public StatusModel(int totalWord) {
        this.totalWord = totalWord;
    }

    public String getIconPath(){
        if(res){
            return "resource/icon/right.png";
        }
        return "resource/icon/wrong.png";
    }

    public int getProgress(){
        return wordCount*100/totalWord;
    }

    public boolean isEnd(){
        return wordCount==totalWord;
    }
}
