package dao;

import bean.Passage;

import java.util.ArrayList;
import java.util.List;

public class PassageData {
    static List<Passage> fakeData = new ArrayList<Passage>();
    static void loadPassage(){
        fakeData.add(new Passage("one","this passage just has one line."));
        fakeData.add(new Passage("Azure","Invent with purpose, realize cost savings, and make your organization more efficient with Microsoft Azure's open and flexible cloud computing platform."));
    }
    public static List<Passage> getData(){
        return fakeData;
    }

}
