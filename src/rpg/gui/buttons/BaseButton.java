package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class BaseButton extends JButton {
    public BaseButton(String text) {
        setText(text);
        /**
         * Agregamos los iconos de la cache de imagen
         */
        setIcon(new ImageIcon(PictureCache.addImage("Button", "panels/Button.png")));
        setRolloverIcon(new ImageIcon(PictureCache.addImage("Button", "panels/Button.png")));
        /**
         * Establecemos el manger de UI.
         */
        setUI(new HoverButtonUI());
    }
}
