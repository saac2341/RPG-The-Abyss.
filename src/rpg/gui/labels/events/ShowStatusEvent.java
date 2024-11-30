package rpg.gui.labels.events;

import rpg.gui.windows.HomeInterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La clase ShowStatusEvent extiende MouseAdapter, lo que permite manejar eventos de mouse sin necesidad de implementar todos los métodos de la interfaz MouseListener.
 */
public class ShowStatusEvent extends MouseAdapter {

    /**
     * Variable que hace referencia a la interfaz principal del juego.
     */
    private HomeInterface homeInterface;

    /**
     * Constructor de la clase, que inicializa la interfaz principal.
     */
    public ShowStatusEvent(HomeInterface homeInterface) {
        this.homeInterface = homeInterface;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
}
