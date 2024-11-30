package rpg.gui.buttons;

import rpg.gui.buttons.events.LoadFileEvent;
import rpg.gui.windows.LoadingWindow;

/**
 * La clase LoadFileButton extiende NewFileButton y representa un botón
 * que permite al usuario cargar una partida guardada.
 */
public class LoadFileButton extends NewFileButton {
    public LoadFileButton(int slot, LoadingWindow loadingWindow){
        super(slot, loadingWindow);
        setText("Cargar Partida");
        /**
         * Elimina el ActionListener existente del botón.
         */
        removeActionListener(getActionListeners()[0]);
        /**
         * Agrega un nuevo ActionListener que maneja el evento de carga de partida.
         */
        addActionListener(new LoadFileEvent(slot, loadingWindow));
    }
}
