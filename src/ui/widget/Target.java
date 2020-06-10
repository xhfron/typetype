package ui.widget;

import ui.util.FontFactory;
import ui.util.WordState;

import javax.swing.*;
import java.awt.*;

public class Target extends JPanel {
    private JLabel label;
    private String word;
    private int x;
    private int y;
    private int id;
    public Target(String word, int x, int y,int id) {
        this.word = word;
        this.x = x;
        this.y = y;
        this.id = id;
        setPreferredSize(new Dimension(50,30));
        label = new JLabel(word);
        add(label);
        updateState(WordState.NORMAL);
        System.out.println(word);
    }

    public int getId() {
        return id;
    }

    public void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    public int down(int path){
        y+=path;
        repaint();
        System.out.println(word+y);
        return y;
    }

    public char getFirstChar(){
        return word.charAt(0);
    }

    public void updateState(WordState wordState){
        switch (wordState){
            case NORMAL:
                setFont(FontFactory.getFont("normal"));
//                setForeground();
                break;
            case SELECT:
                setFont(FontFactory.getFont("select"));
                break;
            case DONE:
                setVisible(false);
                break;
        }
    }

    public boolean updateWord(){
        word = word.substring(1);
        label.setText(word);
        return word.length()==0;
    }

    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);
        g.translate(x,y);
    }

}
