package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * La clase ShopButton extiende BaseButton y representa un botón
 * que permite al usuario acceder a la tienda en la aplicación.
 */
public class ShopButton extends BaseButton{
    /**
     * Constructor de ShopButton que inicializa el botón con el texto "tienda".
     */
    public ShopButton(){
        super("tienda");
    }
    /**
     * Inicializa los iconos para el botón de la tienda.
     * Se establecen los iconos para el estado inactivo y el estado de
     * desplazamiento del ratón.
     */
    @Override
    protected void initIcons() {
        BufferedImage shopIdle = PictureCache.addImage(
                "shopIdle", "");
        BufferedImage shopHover = PictureCache.addImage(
                "shopHover", "");
        setIcon(new ImageIcon(shopIdle));
        setRolloverIcon(new ImageIcon(shopHover));
    }
}
