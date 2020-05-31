package dao;

import bean.RankItem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Errorbook implements java.io.Serializable{
    static HashMap<String,Integer> map;
    static final String errorBookPath = "errorBook.ser";
    public static HashMap<String, Integer> getMap() {
        return map;
    }

    public static void setMap(HashMap<String, Integer> map) {
        Errorbook.map = map;
    }

    private static void count(String word) {
        map.put(word,map.getOrDefault(word,0)+1);
    }

    public static void checkWrongWord(String content, String input) {
        String word = "";
        boolean flag = false;
        for(int i=0;i<content.length();i++){
            char ch = content.charAt(i);
            if(ch>='a'&&ch<='z'){
                word+=ch;
            }else if(ch>='A'&&ch<='Z'){
                word+=ch;
            }else{

                if(flag){
                    count(word);
                }
                word = "";
                flag = false;
                continue;
            }
            flag = ch != input.charAt(i);
        }
    }

    public static void load(){
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
//        Errorbook.getMap().forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String s, Integer integer) {
//                System.out.println(s+integer);
//            }
//        });
    }

    public  static void save(){
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
}
