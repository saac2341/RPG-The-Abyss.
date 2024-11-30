package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * La clase InventoryButton extiende UserButton y representa un botón
 * que permite al usuario acceder al inventario en el juego.
 */
public class InventaryButton extends UserBotton {
    /**
     * Constructor de InventoryButton que inicializa el botón con el texto "Inventario".
     */
    public InventaryButton() {
        super("Inventario");
    }
    protected void initIcons() {
        BufferedImage inventoryIdle = PictureCache.addImage(
                "inventoryIdle", "ButtonParts/BotonD.png");
        BufferedImage inventoryHover = PictureCache.addImage(
                "inventoryHover", "ButtonParts/BotonD.png");
        setIcon(new ImageIcon(inventoryIdle));
        setRolloverIcon(new ImageIcon(inventoryHover));
    }
}