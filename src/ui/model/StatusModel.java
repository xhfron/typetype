package ui.model;

import Item.RankItem;
import dao.Rank;

public class StatusModel{
    private int totalWord;
    private int wordCount;
    private boolean res;
    private int keyTypeCount;
    private int rightCount;
    private int second;
    private String passageName;

    public StatusModel(int totalWord,String passageName) {
        this.passageName = passageName;
        this.totalWord = totalWord;
        keyTypeCount = 0;
        rightCount = 0;
        second = 0;
    }

    public void completeWord(boolean complete){
        if(complete){
            wordCount++;
        }
    }

    public void setRes(boolean res) {
        this.res = res;
        keyTypeCount ++;
        if(res){
            rightCount++;
        }
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

    public void upSecond(){
        second++;
    }

    public int getMinute(){
        return second/60;
    }

    public int getSecond(){
        return second%60;
    }

    public int getSpeed() {
        System.out.println(keyTypeCount+"-----------");
        return 60*keyTypeCount/second;
    }

    public String getAccuracy() {
        return String.format("%.2f",(double)rightCount/keyTypeCount*100)+"%";
    }

    public RankItem getRank(){
        return new RankItem(passageName,getSpeed(),keyTypeCount==0?0:(double)rightCount/keyTypeCount);
    }
}
