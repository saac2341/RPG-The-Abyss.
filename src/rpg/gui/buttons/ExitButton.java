package rpg.gui.buttons;

import rpg.gui.windows.HomeInterface;

public class ExitButton extends UserBotton {

    public ExitButton() {

        super("Salir");
        addActionListener(e -> System.exit(0));
    }
}