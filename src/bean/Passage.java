package bean;

import java.util.List;

public class Passage {
    String title;
    String Content;
    int totalWord;
    List<String> dict;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return Content;
    }

    public int getTotalWord() {
        return totalWord;
    }

    public List<String> getDict() {
        return dict;
    }

    public void setContent(String content) {
        Content = content;
    }
}
