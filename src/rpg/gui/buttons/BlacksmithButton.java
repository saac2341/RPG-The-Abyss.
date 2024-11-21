package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;
import rpg.utils.cache.PictureCache.*;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class BlacksmithButton extends BaseButton {
    /*
    LA HERRERIA.
     */
    public BlacksmithButton() {
        super("Herrero");
    }

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