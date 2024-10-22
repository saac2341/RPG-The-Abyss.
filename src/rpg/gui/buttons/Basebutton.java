package rpg.gui.buttons;

import rpg.utils.*;

import javax.swing.*;

import static javax.swing.text.StyleConstants.setIcon;

public class Basebutton extends JButton {
    public Basebutton(String text){
        setText(text);
        //Agregamos los iconos de la cache
        setIcon(new ImageIcon(PictureCache.addImage("","")));
        setRolloverIcon(new ImageIcon(PictureCache.addImage("", "")));
        setUI(new HoverButtonUI());
    }
}