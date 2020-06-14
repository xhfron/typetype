package dao;

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
