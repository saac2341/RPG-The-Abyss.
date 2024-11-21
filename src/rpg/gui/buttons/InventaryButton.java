package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class InventaryButton extends UserBotton {

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