package ui;

import ui.event.CompleteEvent;
import ui.listener.LineCompleteListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pages extends JPanel{
    private final int lineWidth = 49;//每行多少个字符 英文49个
    private int lineLimit = 4 ; //每页最多多少行 5或者4
    List<Line> lines;
    private LineCompleteListener listener;
    private int nextLoadLine; //当前页的第一行的行号

    public Pages() {
        Pattern p = Pattern.compile("\\s*\n");
        Matcher m = p.matcher(passage);
        passage = m.replaceAll(" ");

        listener = new LineCompleteListener() {
            @Override
            public void nextLine(CompleteEvent event) {
                dealLineComplete(event.getLineNumber());//稍后处理正确率
            }
        };
        BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        setOpaque(false);
        lines = new ArrayList<>();
        nextLoadLine = 0;
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
        return count;
    }

     private void dealLineComplete(int lineNumber){
        System.out.println(nextLoadLine);
        System.out.println(lineNumber);
        System.out.println();
        if(lineNumber<nextLoadLine-1){
            lines.get(lineNumber+1).getFocus();
        }else{
            loadPage();
            lines.get(lineNumber+1).getFocus();
        }

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
     String passage = "Dou Zhi Li(1), 3rd stage!\n" +
             "\n" +
             "Facing the Magical Testing Monument as it displayed the 5 big hurtful words, the youth stood expressionless, lips curled in a small self-ridiculing smile. He tightly clenched his fist and because of the strength used, his slightly sharp fingernails dug deep into the palm of his hand, bringing brief moments of pain.\n" +
             "\n" +
             "“Xiao Yan, Dou Zhi Li, 3rd stage! Rank: Low!” Beside the Magical Testing Monument, a middle-aged man looked at the results on the monument and announced them with an indifferent voice.\n" +
             "\n" +
             "Immediately after the middle-aged man finished speaking, without much surprise, the people in the square started a commotion, ridiculing him.\n" +
             "\n" +
             "“3rd stage? Hmmhmm, as expected. This ‘genius’ has once again taken a step back.”\n" +
             "\n" +
             "“Ai, this piece of trash really disgraced his entire clan.”\n" +
             "\n" +
             "“If his father wasn’t the clan leader, this kind of trash would already have been kicked out of the clan. Nobody would care about him, and there wouldn’t be such a thing as leeching off the clan home.”\n" +
             "\n" +
             "“How could the once famous genius of Wu Tan Cheng(2) fall to become like this over the past few years?”\n" +
             "\n" +
             "“Who knows? Maybe he did something unforgivable and caused the gods to get angry.”\n" +
             "\n" +
             "The ridicule and laughter directed at him came from all directions and resonated in the motionless youth’s ears, as if piercing his heart. He could not help but breathe heavily.\n" +
             "\n" +
             "He raised his head to reveal a delicate and immature face, jet black eyes glancing past the people of his age that ridiculed him as well. His lips, which were previously full of self-ridicule, turned to fill with bitterness instead.\n" +
             "\n" +
             "“These people, were they always this cold? Or was it because three years ago they smiled humbly to congratulate me, and now they wanted to take it back?” Smiling bitterly, Xiao Yan turned around and silently walked back to the group of people. His lonesome figure seemed to be unable to fit in with the surroundings.\n" +
             "\n" +
             "“Next up, Xiao Mei!”\n" +
             "\n" +
             "Hearing the tester’s voice, a teenage girl quickly ran up from in the crowd. The moment she got on stage, the murmurings and discussions quietened down and every pair of fiery eyes were locked on her face.\n" +
             "\n" +
             "The teenage girl wasn’t more than 14 years old. Although her beauty wasn’t immediately evident, her small childish face combined with her innocence captured the attention of the audience.\n" +
             "\n" +
             "She quickly stepped forward and put her tiny hands on the black stone monument. She then closed her eyes gently.\n" +
             "\n" +
             "As the girl closed her eyes, the monument shined brightly once again.\n" +
             "\n" +
             "‘Dou Zhi Li, 7th stage!’\n" +
             "\n" +
             "“Xiao Mei, Dou Zhi Li, 7th stage! Rank: High!”";
}
