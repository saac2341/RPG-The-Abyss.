package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * La clase LabelUI extiende BasicLabelUI, lo que permite personalizar la apariencia y el comportamiento de un JLabel.
 */
public class LabelUI extends BasicLabelUI {
    /**
     * Variable para almacenar el tamaño del JLabel.
     */
    private Dimension size;

    /**
     * Variable para almacenar un icono que se puede usar en el JLabel.
     */
    ImageIcon icon;

    /**
     * Constructor de la clase, que inicializa el tamaño y el icono del JLabel.
     */
    public LabelUI(Dimension size, ImageIcon icon) {
        this.size = size;
        this.icon = icon;
    }

    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
    }
}