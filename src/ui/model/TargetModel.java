package ui.model;

import ui.util.FontFactory;
import ui.util.WordState;

import javax.swing.*;
import java.awt.*;

public class TargetModel {
    private String word;
    private int x;
    private int y;
    private int id;
    private WordState state;

    public TargetModel(String word, int x, int y, int id) {
        this.word = word;
        this.x = x;
        this.y = y;
        this.id = id;
        System.out.println(word);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getWord() {
        return word;
    }

    public void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int down(int path) {
        y += path;
        System.out.println(word + y);
        return y;
    }

    public char getFirstChar() {
        return word.charAt(0);
    }

    public boolean updateWord() {
        word = word.substring(1);
        return word.length() == 0;
    }

    public WordState getState() {
        return state;
    }

    public void setState(WordState state) {
        this.state = state;
    }
}
