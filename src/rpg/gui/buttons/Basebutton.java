package rpg.gui.buttons;

import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class Basebutton extends JButton {
    public Basebutton(String text){
        setText(text);
        //Agregamos los iconos de la cache
        setIcon(new ImageIcon(PictureCache.addImage("Button","panels/Button.png")));
        setRolloverIcon(new ImageIcon(PictureCache.addImage("Button", "panels/Button.png")));
        setUI(new HoverButtonUI());
    }
}
