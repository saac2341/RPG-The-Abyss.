package rpg.gui.buttons;

import rpg.gui.buttons.events.NewFileEvent;
import rpg.gui.windows.NewFileWindow;

/**
 * La clase CreateButton extiende UserButton y representa un botón
 * que permite al usuario crear una nueva aventura.
 */
public class CreateButton extends UserBotton {
    /**
     * Constructor de CreateButton que inicializa el botón con el texto "¡A la aventura!"
     * y agrega un listener para manejar el evento de creación de un nuevo archivo.
     */
    public CreateButton(int slot, NewFileWindow window){
        super ("¡A la aventura!");
        addActionListener(new NewFileEvent(slot, window));
    }
}
