package ui.model;

import Item.Passage;
import ui.model.TargetModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTargetModel implements Runnable {
    private Queue<TargetModel> targetQueue;
    private List<Integer> bornPosition;
    private final int yLimit =400;
    private final int targetLimit = 4;
    private final int targetWidth = 100;
    private Passage passage;
    private boolean flag = true;
    private TargetModel current;
    public MyTargetModel(Passage passage) {
        this.passage = passage;
        targetQueue = new LinkedList<>();
        bornPosition= new ArrayList<>();
        for(int i=0;i<targetLimit;i++){
            bornPosition.add(0);
        }
        current = null;
    }

    public void dealInput(char input){
        System.out.println(input);
    }

    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(targetQueue.size()<targetLimit&&passage.hasNextWord()){
                makeTarget();
            }
            for(TargetModel model : targetQueue){
                if(model.down(10)>yLimit){
                    System.out.println("发送事件");
                    return;
                    }
            }
        }
    }

    public Queue<TargetModel> getTargetQueue() {
        return targetQueue;
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
        TargetModel target = new TargetModel(passage.getNextWord(),
                targetWidth*pos,0,pos);
        targetQueue.add(target);
        return true;
    }
}
