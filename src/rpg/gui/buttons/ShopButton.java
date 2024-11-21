package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ShopButton extends BaseButton{
    public ShopButton(){
        super("tienda");
    }

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
