package dao;

import bean.Passage;
import bean.RankItem;

import java.util.List;

public class History {
    private Errorbook errorbook;
    private Rank rank;

    public History(Errorbook errorbook, Rank rank) {
        this.errorbook = errorbook;
        this.rank = rank;
    }
    public static void analyze(Passage passage,String input,int speed,double correctRate){
        Errorbook.checkWrongWord(passage.getContent()+" ",input+" ");
        Rank.addItem(new RankItem(passage.getTitle(),speed,correctRate));
    }
    public static void load(){
        Errorbook.load();
        Rank.load();
//        PassageData.loadPassage();
    }
    public static void save(){
        Errorbook.save();
        Rank.save();
    }
}
