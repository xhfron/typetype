package dao;

import java.io.*;
import java.util.HashMap;

public class Errorbook implements java.io.Serializable{
    private static HashMap<String,Integer> map;
    private static final String errorBookPath = "errorBook.ser";

    public static void count(String word) {

        map.put(word,map.getOrDefault(word,0)+1);
    }

    static void load(){
        File rankFile = new File(errorBookPath);
        try{
            if(rankFile.exists()){
                Errorbook.setMap((HashMap<String,Integer>) new ObjectInputStream(new FileInputStream(rankFile.getPath())).readObject());
            }else {
                Errorbook.setMap(new HashMap<>());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void save(){
        try {
            FileOutputStream fileOut = new FileOutputStream(errorBookPath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Errorbook.getMap());
            out.close();
            fileOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clear() {
        map.clear();
    }

    public static HashMap<String, Integer> getMap() {

        return map;
    }

    private static void setMap(HashMap<String, Integer> map) {
        Errorbook.map = map;
    }
}
