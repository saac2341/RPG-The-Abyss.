package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.windows.HomeInterface;
import rpg.gui.windows.LoadingWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * / La clase LoadFileEvent implementa la interfaz ActionListener, lo que significa que puede ser utilizada como un manejador de eventos para acciones.
 */
public class LoadFileEvent implements ActionListener {
    /**
     * Variable de cargará de un archivo.
     */
    private int slot;
    /**
     * Variable que hace referencia a la ventana de carga que se mostrará durante el proceso de carga.
     */
    private LoadingWindow loadingWindow;

    /**
     * Constructor de la clase, que inicializa el slot y la ventana de carga.
     */
    public LoadFileEvent(int slot, LoadingWindow loadingWindow) {
        this.slot = slot;
        this.loadingWindow = loadingWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Carga un objeto Player desde el slot especificado.
         */
        Player player = Player.load(slot);
        /**
         * Cierra la ventana de carga una vez que el jugador ha sido cargado.
         */
        loadingWindow.dispose();
        /**
         * Crea una nueva interfaz de inicio, pasando el jugador cargado y el slot.
         */
        new HomeInterface(player, slot);
    }
}
