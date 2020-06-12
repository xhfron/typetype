package ui.model;

import ui.listener.CheckListener;
import ui.view.StatusBar;

public class StatusModel implements CheckListener {
    private StatusBar statusBar;

    public void setStatusBar(StatusBar statusBar) {
        this.statusBar = statusBar;
    }

    public StatusModel() {

    }

    @Override
    public void sendRes(boolean right) {
       statusBar.setIconPath(getIconPath(right));
       statusBar.repaint();
    }

    public String getIconPath(boolean res){
        if(res){
            return "resource/icon/right.png";
        }
        return "resource/icon/wrong.png";
    }

    @Override
    public void sendProgress(int progress) {
       statusBar.setProgress(progress);
       statusBar.repaint();
    }

}
