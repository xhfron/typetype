package ui;

import ui.event.CompleteEvent;
import ui.event.FinishEvent;
import ui.listener.LineCompleteListener;
import ui.listener.PassageFinishListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pages extends JPanel{
    private final int lineWidth = 4;//每行多少个字符 英文49个
    private int lineLimit = 4 ; //每页最多多少行 5或者4
    List<Line> lines;
    private LineCompleteListener listener;
    private int nextLoadLine; //当前页的第一行的行号
    private int currentLine;
    String passage;
    PassageFinishListener finishListener;
    public Pages(String passage) {
        this.passage = passage;
        Pattern p = Pattern.compile("\\s*\n");
        Matcher m = p.matcher(passage);
        passage = m.replaceAll(" ");

        listener = new LineCompleteListener() {
            @Override
            public void nextLine(CompleteEvent event) {
                lineComplete(event.getLineNumber());//稍后处理正确率
            }
        };
        BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        setOpaque(false);
        lines = new ArrayList<>();
        nextLoadLine = 0;
        currentLine = 0;
        makeLine(lines);
        loadPage();
    }

    private int makeLine(List<Line> lines){
        int length = passage.length();
        int count= length/lineWidth;
        for(int i=0;i<count;i++){
            Line temp = new Line(i,passage.substring(i*lineWidth,(i+1)*lineWidth));
            temp.addLineCompleteListener(listener);
            lines.add(i,temp);
        }
        if(length%lineWidth!=0){
            lines.add(new Line(count,passage.substring(count*lineWidth)));
            count++;
        }
        System.out.println("生成了"+count);
        return count;
    }

     private void lineComplete(int lineNumber){
        System.out.println(nextLoadLine);
        System.out.println(lineNumber);
        System.out.println();
        if(lineNumber==lines.size()-1){
            passageComplete();
            return;
        }
        if(lineNumber<nextLoadLine-1){
            lines.get(lineNumber+1).getFocus();
        }else{
            loadPage();
            lines.get(lineNumber+1).getFocus();
        }
        currentLine++;
     }

    private void passageComplete() {
        String input = "";
        for(Line line : lines){
            line.stop();
            input += line.getInput();
        }
        System.out.println("收工了");
        finishListener.settle(new FinishEvent(this,input));
    }

    private void loadPage(){
        removeAll();
        repaint();
        for(int i=nextLoadLine;i<Math.min(nextLoadLine+lineLimit,lines.size());i++){
            add(lines.get(i));
            add(Box.createVerticalStrut(8));
        }
        nextLoadLine += lineLimit;
        repaint();
     }

    public void addFinishListener(PassageFinishListener passageFinishListener) {
        finishListener = passageFinishListener;
    }
}
