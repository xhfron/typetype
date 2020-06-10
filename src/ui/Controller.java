package ui;

import Item.Passage;
import ui.listener.InputListener;
import ui.pages.Stage;
import ui.util.WordState;
import ui.widget.Target;

import javax.swing.Timer;
import java.util.*;


public class Controller implements InputListener {

    private final int yLimit = 600;
    private final int targetLimit = 4;
    private final int targetWidth = 30;
    private Stage stage;
    private Queue<Target> targetQueue;
    private Passage passage;
    private List<Integer> bornPosition;
    private Target currentTarget;
    public Controller(Passage passage,Stage stage) {
        this.passage = passage;
        currentTarget = null;
        targetQueue = new LinkedList<>();
        bornPosition = new ArrayList<>();
        for(int i=0;i<targetLimit;i++){
            bornPosition.set(i,0);
        }
        this.stage = stage;
        new Timer(1000,e->{
            refresh();
        });
    }

    private void refresh() {
        for(Target target : targetQueue){
            if(target.down(10)>yLimit){
                defeat();
            };
        }
        while(targetQueue.size()<targetLimit&&passage.hasNextWord()){
            makeTarget();
        }
    }

    void defeat(){

    }

    boolean makeTarget(){
        int pos = -1;
        for(int i=0;i<targetLimit;i++){
            if(bornPosition.get(i)==0){
                bornPosition.set(i,1);
                pos = i;
                break;
            }
        }
        if(pos==-1){
            return false;
        }
        Target target = new Target(passage.getNextWord(),
                targetWidth*pos,0,pos);
        targetQueue.add(target);
        stage.add(target);
        return true;
    }

    public boolean dealKey(char input){
        if(currentTarget==null){
            for(Target target : targetQueue){
                if(input==target.getFirstChar()){
                    updateWord(target);
                    return true;
                }
            }
        }else if(input==currentTarget.getFirstChar()){
                updateWord(currentTarget);
                return true;
            }
        return false;
    }

    private void updateWord(Target target){
        if(target.updateWord()){
            bornPosition.set(target.getId(),0);
            targetQueue.remove(target);
            target.updateState(WordState.DONE);
        }else{
            target.updateState(WordState.SELECT);
        }
    }
}
