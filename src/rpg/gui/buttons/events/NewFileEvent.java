package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.windows.HomeInterface;
import rpg.gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase NewFileEvent implementa la interfaz ActionListener, lo que permite manejar eventos de acción.
 */
public class NewFileEvent implements ActionListener {

    /**
     * Variables que representan donde se guardará el nuevo archivo de jugador.
     */
    int slot;
    NewFileWindow window;

    /**
     * Constructor de la clase, que inicializa el slot y la ventana.
     */
    public NewFileEvent(int slot, NewFileWindow window) {
        this.slot = slot;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Cierra la ventana de creación de archivo una vez que se ha activado el evento.
         */
        window.dispose();
        /**
         * Crea un nuevo objeto Player utilizando el nombre proporcionado en la ventana.
         */
        Player player = new Player(window.getName());
        /**
         * Guarda el nuevo jugador en el slot especificado.
         */
        player.save(slot);
        /**
         * Crea una nueva interfaz de inicio, pasando el jugador recién creado y el slot.
         */
        new HomeInterface(player, slot);
    }
}
