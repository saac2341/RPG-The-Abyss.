package rpg.gui.buttons;

import rpg.gui.windows.HomeInterface;

/**
 * La clase FleeButton extiende UserButton y representa un botón
 * que permite al usuario intentar huir del enemigo cuando este
 * es muy dificil de vencer.
 */
public class FleeButton extends UserBotton{
    public FleeButton(HomeInterface game){
        super("Huir");
        addActionListener(e -> game.tryToFlee());
    }
}
