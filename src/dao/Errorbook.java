package dao;

import java.util.List;

public class Errorbook {

    private static void count(String word) {
        System.out.println(word);
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
}
