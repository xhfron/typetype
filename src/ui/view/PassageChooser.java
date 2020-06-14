package ui.view;

import Item.Passage;
import ui.UIFrame;

import javax.swing.*;
import java.io.*;

public class PassageChooser extends JFrame{
    private JFileChooser fileChooser;

    PassageChooser() {
        fileChooser = new JFileChooser();
        fileChooser.setSize(750,450);
        fileChooser.setLocation(600,400);
        add(fileChooser);
        choose();
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
                reader.close();
                content.append(" ");
                new UIFrame(new Stage(new Passage(f.getName(),content.toString())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
