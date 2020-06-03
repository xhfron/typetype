package bean;

import java.util.List;

public class Passage {
    String title ;
    String Content;

    public Passage(String title, String content) {
        this.title = title;
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
