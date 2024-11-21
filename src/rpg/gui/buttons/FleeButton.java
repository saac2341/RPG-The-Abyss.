package rpg.gui.buttons;

import rpg.gui.windows.HomeInterface;

public class FleeButton extends UserBotton{
    public FleeButton(HomeInterface game){
        super("Huir");
        addActionListener(e -> game.tryToFlee());
    }
}
