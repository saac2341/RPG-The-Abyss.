package rpg.gui.buttons;
import rpg.gui.windows.HomeInterface;

/**
 * La clase ExitButton extiende UserButton y representa un botón
 * que permite al usuario salir del juego.
 */
public class ExitButton extends UserBotton {
    /**
     * Constructor de ExitButton que inicializa el botón con el texto "Salir"
     * y agrega un ActionListener que cierra la aplicación al ser presionado.
     */
    public ExitButton() {
        super("Salir");
        addActionListener(e -> System.exit(0));
    }
}