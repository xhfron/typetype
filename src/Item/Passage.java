package Item;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Passage {
    private String title ;
    private List<String> words;
    private ListIterator<String> iterator;
    public Passage(String title,String content) {
        this.title = title;
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
                if(word.length()>0){
                    words.add(word);
                    word = "";
                }
            }
        }
    }

    public String getNextWord() {
        return iterator.next();
    }

    public boolean hasNextWord(){
        return iterator.hasNext();
    }

    public String getTitle() {
        return title;
    }
}
