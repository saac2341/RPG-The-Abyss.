package rpg.gui.buttons;

import rpg.gui.buttons.events.NewPlayerEvent;
import rpg.gui.windows.LoadingWindow;

public class NewFileButton extends UserBotton {
   int slot;
   LoadingWindow loadingWindow;

    public NewFileButton(int slot, LoadingWindow loadingWindow) {
        super("Nueva Partida");
        this.slot = slot;
        addActionListener(new NewPlayerEvent(slot, loadingWindow));
    }
}
