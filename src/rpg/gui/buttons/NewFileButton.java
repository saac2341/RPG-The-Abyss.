package rpg.gui.buttons;

import rpg.gui.buttons.events.NewPlayerEvent;
import rpg.gui.windows.LoadingWindow;

/**
 * La clase NewFileButton extiende UserButton y representa un botón
 * que permite al usuario iniciar una nueva partida.
 */
public class NewFileButton extends UserBotton {
   int slot;
   LoadingWindow loadingWindow;
    /**
     * Constructor de NewFileButton que inicializa el botón con el texto "Nueva Partida"
     * y configura el evento de acción para crear una nueva partida.
     */
    public NewFileButton(int slot, LoadingWindow loadingWindow) {
        super("Nueva Partida");
        this.slot = slot;
        addActionListener(new NewPlayerEvent(slot, loadingWindow));
    }
}
