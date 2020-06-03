package ui;

import bean.Passage;
import dao.PassageData;
import ui.component.MyPanel;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class PassageChooser extends JFrame{
    JFileChooser fileChooser;
    JFrame frame;
    public PassageChooser() {
        fileChooser = new JFileChooser();
        fileChooser.setSize(750,450);
        fileChooser.setLocation(600,400);
        add(fileChooser);
        choose();
//        setVisible(true);
    }

    private void choose(){
        File f;
        StringBuffer content = new StringBuffer();
        if(fileChooser.showDialog(this,"导入文章")==JFileChooser.APPROVE_OPTION){
             f = fileChooser.getSelectedFile();
            try {
                String temp;
                BufferedReader reader= new BufferedReader(new FileReader(f));
                while((temp=reader.readLine())!=null){
                    content.append(temp);
                }
                new UIFrame(new TypingUI(new Passage(f.getName(),content.toString())));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
