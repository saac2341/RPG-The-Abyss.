package rpg.gui.buttons;

import rpg.gui.HomeInterface;
import rpg.gui.buttons.events.AttackEvent;

public class ExitButton extends UserBotton {

    public ExitButton(HomeInterface game) {

        super("Salir");
        addActionListener(e -> System.exit(0));
    }
}