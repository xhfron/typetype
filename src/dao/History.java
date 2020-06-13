package dao;

import Item.Passage;
import Item.RankItem;

public class History {
    public static void load(){
        Errorbook.load();
        Rank.load();
    }
    public static void save(){
        Errorbook.save();
        Rank.save();
    }
}
