package Item;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Passage {
    private String title;
    private List<String> words;
    private ListIterator<String> iterator;
    private int index = 0;
    public Passage(String title,String content) {
        this.title = title;
        content = "The drawString method does not handle new-lines. You'll have to split the string on new-line characters yourself and draw the lines one by one with a proper ";

        words = new ArrayList<>();
        iterator = words.listIterator();
        makeWords(content);
    }

    void makeWords(String content){
        String word = "";
        for(int i=0;i<content.length();i++){
            char ch = content.charAt(i);
            if(ch>='a'&&ch<='z'){
                word+=ch;
            }else if(ch>='A'&&ch<='Z'){
                word+=ch;
            }else{
                 if(word.length()>0&&word.length()<10){
                    words.add(word);
                }
                word = "";
            }
        }
    }

    public String getNextWord() {
        return words.get(index++);

    }

    public boolean hasNextWord(){
        return index<words.size();
    }

    public String getTitle() {
        return title;
    }
}