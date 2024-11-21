package rpg.gui.buttons.events;

import rpg.gui.windows.HomeInterface;
import rpg.gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayerEvent implements ActionListener {
    int slot;
    HomeInterface homeInterface;

    public NewPlayerEvent(int slot, HomeInterface homeInterface){
        this.slot=slot;
        this.homeInterface = homeInterface;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        homeInterface.dispose();
        new NewFileWindow();
    }
}
