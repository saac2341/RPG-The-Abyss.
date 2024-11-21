package rpg.gui.buttons;

import rpg.gui.ui.HoverButtonUI;

import javax.swing.*;

public abstract class BaseButton extends JButton {
    public BaseButton(String text) {
        setText(text);
        /**
         * Agregamos los iconos de la cache de imagen
         */
        initIcons();
        setUI(new HoverButtonUI());
        /**
         * Establecemos el manger de UI.
         */
    }
    protected abstract void initIcons();
    }
