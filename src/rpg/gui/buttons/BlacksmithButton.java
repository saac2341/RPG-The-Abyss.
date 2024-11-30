package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;
import rpg.utils.cache.PictureCache.*;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * La clase BlacksmithButton extiende BaseButton y representa un botón
 * que permite al usuario interactuar con el herrero en el juego.
 */
public class BlacksmithButton extends BaseButton {

    /**
     * Constructor de BlacksmithButton que inicializa el botón con el texto "Herrero".
     */
    public BlacksmithButton() {
        super("Herrero");
    }

    /**
     * Inicializa los iconos del botón, incluyendo el icono normal y el icono
     * que se muestra cuando el mouse está sobre el botón.
     */
    @Override
    protected void initIcons() {
        BufferedImage blacksmithIdle = PictureCache.addImage(
                "blacksmithIdle", "ButtonParts/BotonD.png");
        BufferedImage blacksmithHover = PictureCache.addImage(
                "blacksmithHover", "ButtonParts/BotonD.png");
        setIcon(new ImageIcon(blacksmithIdle));
        setRolloverIcon(new ImageIcon(blacksmithHover));
    }
}