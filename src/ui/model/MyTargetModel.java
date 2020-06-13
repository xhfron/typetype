package ui.model;

import Item.Passage;
import dao.Errorbook;
import ui.util.WordState;
import ui.view.StatusBar;
import ui.view.TargetPanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTargetModel{
    private final int yLimit = 470;
    private final int targetLimit = 8;
    private final int targetWidth = 100;
    private Queue<WordModel> targetQueue;
    private List<Integer> bornPosition;
    private Passage passage;
    private WordModel current;
    private boolean right;
    private boolean complete;
    private final int downPath = 10;
    private boolean fail;
    public boolean isFail() {
        return fail;
    }
    private boolean typeWrong;


    public MyTargetModel(Passage passage) {
        this.passage = passage;
        targetQueue = new LinkedList<>();
        bornPosition = new ArrayList<>();
        for (int i = 0; i < targetLimit; i++) {
            bornPosition.add(0);
        }
        current = null;
        complete = false;
        fail = false;
        typeWrong = false;
    }

    public void dealKey(char input) {
        right = true;
        if (current == null) {
            for (WordModel target : targetQueue) {
                if (input == target.getFirstChar()) {
                    current = target;
                    break;
                }
            }
        }
        if (current == null) {
            right = false;
        } else if (input == current.getFirstChar()) {
            updateWord(current);
        } else if(current!=null){
            right = false;
        }
        if(!right){
            typeWrong = true;
        }
    }

    public boolean isRight() {
        return right;
    }
    public boolean isComplete(){
        if(complete){
            complete = false;
            return true;
        }
        return false;
    }

    private void updateWord(WordModel wordModel) {
        if (wordModel.updateWord()) {
            bornPosition.set(wordModel.getId(), 0);
            targetQueue.remove(wordModel);
            wordModel.setState(WordState.DONE);
            targetQueue.remove(wordModel);
            Errorbook.count(current.getOriginWord());
            typeWrong = false;
            current = null;
            complete = true;
        } else {
            wordModel.setState(WordState.SELECT);
        }
    }



    public Queue<WordModel> getTargetQueue() {
        return targetQueue;
    }

    private boolean makeTarget() {
        int pos = -1;
        for (int i = 0; i < targetLimit; i++) {
            if (bornPosition.get(i) == 0) {
                bornPosition.set(i, 1);
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            return false;
        }
        WordModel target = new WordModel(passage.getNextWord(),
                targetWidth * pos, 0, pos);
        targetQueue.add(target);
        return true;
    }
    public void refresh(){
        while (targetQueue.size() < targetLimit && passage.hasNextWord()) {
            makeTarget();
        }
        for (WordModel model : targetQueue) {
            if (model.down(downPath) > yLimit) {
                fail = true;
                return;
            }
        }
    }
}
