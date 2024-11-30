package rpg.gui.buttons.events;

import rpg.gui.windows.LoadingWindow;
import rpg.gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase NewPlayerEvent implementa la interfaz ActionListener, lo que permite manejar eventos de acción.
 */
public class NewPlayerEvent implements ActionListener {

    /**
     * Variables que representan donde se puede crear un nuevo jugador y la ventana de carga.
     */
    int slot;
    LoadingWindow loadingWindow;

    /**
     * Constructor de la clase, que inicializa el slot y la ventana de carga.
     */
    public NewPlayerEvent(int slot, LoadingWindow loadingWindow) {
        this.slot = slot;
        this.loadingWindow = loadingWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Cierra la ventana de carga una vez que se ha activado el evento.
         */
        loadingWindow.dispose();
        /**
         * Abre una nueva ventana para crear un nuevo archivo de jugador, pasando el slot correspondiente.
         */
        new NewFileWindow(slot);
    }
}
