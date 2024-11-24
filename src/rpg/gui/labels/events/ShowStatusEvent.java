package rpg.gui.labels.events;

import rpg.gui.windows.HomeInterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowStatusEvent extends MouseAdapter {
    private HomeInterface homeInterface;
    public ShowStatusEvent(HomeInterface homeInterface){
        this.homeInterface=homeInterface;
    }

    public void mouseClicked(MouseEvent e){
        homeInterface.getStatusFrame().setVisible(true);
    }
}
