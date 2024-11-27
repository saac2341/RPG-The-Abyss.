package rpg.gui.buttons.events;

import rpg.gui.windows.LoadingWindow;
import rpg.gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayerEvent implements ActionListener {
    int slot;
    LoadingWindow loadingWindow;

    public NewPlayerEvent(int slot, LoadingWindow loadingWindow) {
        this.slot = slot;
        this.loadingWindow = loadingWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        loadingWindow.dispose();
        new NewFileWindow(slot);
    }
}
