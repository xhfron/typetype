//package ui;
//
//import Item.Passage;
//import ui.listener.InputListener;
//import ui.util.WordState;
//import ui.widget.MyPanel;
//import ui.widget.Target;
//import java.awt.*;
//import java.util.*;
//import java.util.List;
//
//
//public class Controller implements InputListener{
//
//    private final int yLimit =50;
//    private final int targetLimit = 4;
//    private final int targetWidth = 30;
//    private MyPanel wordPanel;
//
//
//
//    private Target currentTarget;
//    private boolean flag = true;
////    private Stage stage;
//
//    public Controller(Passage passage) {
//        this.passage = passage;
//        currentTarget = null;
//
//
//        wordPanel = new MyPanel();
//       new UIFrame(wordPanel);
//        EventQueue.invokeLater(() -> {
//            while (true){
//                refresh();
//                System.out.println("刷新");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//
//    private void refresh() {
////        for(Target target : targetQueue){
////            if(target.down(10)>yLimit){
////                defeat();
////                return;
////            }
////        }
//        while(targetQueue.size()<targetLimit&&passage.hasNextWord()){
//            makeTarget();
//        }
//    }
//
//    void defeat(){
//        System.out.println("you lose");
//    }
//
//
//
//    public boolean dealKey(char input){
//        if(currentTarget==null){
//            for(Target target : targetQueue){
//                if(input==target.getFirstChar()){
//                    updateWord(target);
//                    return true;
//                }
//            }
//        }else if(input==currentTarget.getFirstChar()){
//                updateWord(currentTarget);
//                return true;
//            }
//        return false;
//    }
//
//    private void updateWord(Target target){
//        if(target.updateWord()){
//            bornPosition.set(target.getId(),0);
//            targetQueue.remove(target);
//            target.updateState(WordState.DONE);
//        }else{
//            target.updateState(WordState.SELECT);
//        }
//    }
//
//}
