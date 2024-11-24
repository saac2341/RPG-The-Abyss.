package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.windows.HomeInterface;
import rpg.gui.windows.LoadingWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFileEvent implements ActionListener {

    private int slot;
    private LoadingWindow loadingWindow;

    public LoadFileEvent(int slot, LoadingWindow loadingWindow) {
        this.slot = slot;
        this.loadingWindow = loadingWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Player player = Player.load(slot);
        loadingWindow.dispose();
        new HomeInterface(player, slot);
    }
}
