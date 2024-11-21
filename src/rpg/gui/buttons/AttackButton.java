package rpg.gui.buttons;

import rpg.gui.windows.HomeInterface;
import rpg.gui.buttons.events.AttackEvent;

public class AttackButton extends UserBotton {

    public AttackButton(HomeInterface game) {

        super("Atacar");
        addActionListener(new AttackEvent(game));
    }
}
