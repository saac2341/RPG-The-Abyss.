package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * La clase EnemyLabelUI extiende BasicLabelUI, permitiendo personalizar la apariencia y el comportamiento de un JLabel.
 */
public class EnemyLabelUI extends BasicLabelUI {
    /**
     * Variable para almacenar un icono que representa al enemigo.
     */
    ImageIcon icon;
    /**
     * Constructor de la clase que inicializa el icono.
     */
    public EnemyLabelUI(ImageIcon icon) {
        this.icon = icon;
    }

    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
    }

    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        /**
         * Activa el antialiasing para un mejor renderizado de gráficos.
         */
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        /**
         * Dibuja el icono en la posición (0, 0) del JLabel.
         */
        g2d.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), c);
    }
}