package dao;

import Item.RankItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Rank{
    static private List<RankItem> ranks;
    private static final String rankFilePath = "rank.ser";

    public static void load(){
        File rankFile = new File(rankFilePath);
        try{
            if(rankFile.exists()){
                Rank.setRanks((List<RankItem>) new ObjectInputStream(new
                        FileInputStream(rankFile.getPath())).readObject());
            }else {
                Rank.setRanks(new ArrayList<>());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for(RankItem item : Rank.getRanks()){
            System.out.println(item);
        }
    }

    static void save(){
        try {
            FileOutputStream fileOut = new FileOutputStream(rankFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Rank.getRanks());
            out.close();
            fileOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addItem(RankItem rankItem) {
        ranks.add(rankItem);
        sort();
    }

    public static void clear() {

        ranks.clear();
    }

    private static void sort(){
        ranks.sort(new Comparator<RankItem>() {
            @Override
            public int compare(RankItem rankItem, RankItem t1) {
                return t1.getSpeed()-rankItem.getSpeed();
            }
        });
    }

    public static List<RankItem> getRanks() {

        return ranks;
    }

    public static void setRanks(List<RankItem> ranks) {

        Rank.ranks = ranks;
    }
}
