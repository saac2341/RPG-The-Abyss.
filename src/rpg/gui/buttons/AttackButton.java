package rpg.gui.buttons;

import rpg.gui.windows.HomeInterface;
import rpg.gui.buttons.events.AttackEvent;

/**
 * La clase AttackButton extiende UserButton y representa un botón
 * que permite al usuario realizar una acción de ataque en el juego.
 */
public class AttackButton extends UserBotton {

    /**
     * Constructor de AttackButton que inicializa el botón con el texto "Atacar"
     * y agrega un listener para manejar el evento de ataque.
     */
    public AttackButton(HomeInterface game) {
        super("Atacar");
        addActionListener(new AttackEvent(game));
    }
}
