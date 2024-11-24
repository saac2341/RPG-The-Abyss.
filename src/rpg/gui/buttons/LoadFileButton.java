package rpg.gui.buttons;

import rpg.gui.buttons.events.LoadFileEvent;
import rpg.gui.LoadingWindow;

public class LoadFileButton extends NewFileButton {
    public LoadFileButton(int slot, LoadingWindow loadingWindow){
        super(slot, LoadingWindow);
        setText("Cargar Partida");
        removeActionListener(getActionListeners()[0]);
        addActionListener(new LoadFileEvent(slot, loadingWindow));
    }
}
