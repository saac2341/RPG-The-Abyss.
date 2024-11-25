package rpg.gui.buttons;

import rpg.gui.buttons.events.LoadFileEvent;
import rpg.gui.windows.LoadingWindow;

public class LoadFileButton extends NewFileButton {
    public LoadFileButton(int slot, LoadingWindow loadingWindow){
        super(slot, loadingWindow);
        setText("Cargar Partida");
        removeActionListener(getActionListeners()[0]);
        addActionListener(new LoadFileEvent(slot, loadingWindow));
    }
}
