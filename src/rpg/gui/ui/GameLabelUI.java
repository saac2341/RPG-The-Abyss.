package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * La clase GameLabelUI extiende BasicLabelUI para personalizar la apariencia de un JLabel.
 * Esta implementación permite mostrar un ícono y texto en un JLabel con un diseño específico.
 */
public class GameLabelUI extends BasicLabelUI {

    protected final Dimension size;
    protected final ImageIcon icon;
    protected Rectangle paintIconR = new Rectangle();
    protected Rectangle paintTextR = new Rectangle();

    /**
     * Constructor de GameLabelUI que inicializa el tamaño y el ícono.
     */
    public GameLabelUI(Dimension size, ImageIcon icon) {

        this.size = size;
        this.icon = icon;
    }

    /**
     * Instala las configuraciones predeterminadas para el JLabel.
     */
    @Override
    protected void installDefaults(JLabel c) {

        c.setOpaque(false);
        c.setBorder(null);
    }

    /**
     * Dibuja el JLabel en el componente.
     * Dibuja el ícono y el texto en las posiciones calculadas.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight());
        int textX = 40 + ((paintIconR.width - 40 - (fm.stringWidth(label.getText()))) / 2);
        int textY = paintTextR.y + fm.getAscent();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(icon.getImage(), 0, 0, size.width, size.height, c);
        super.paintEnabledText(label, g, clippedText, textX, textY);
    }

    /**
     * Calcula el diseño del JLabel, incluyendo el ícono y el texto.
     */
    protected String layout(JLabel label, FontMetrics fm,
                            int width, int height) {
        Insets insets = label.getInsets(null);
        String text = label.getText();
        Icon icon = (label.isEnabled()) ? label.getIcon() :
                label.getDisabledIcon();
        Rectangle paintViewR = new Rectangle();
        paintViewR.x = insets.left;
        paintViewR.y = insets.top;
        paintViewR.width = width - (insets.left + insets.right);
        paintViewR.height = height - (insets.top + insets.bottom);
        paintIconR.x = paintIconR.y = paintIconR.width = paintIconR.height = 0;
        paintTextR.x = paintTextR.y = paintTextR.width = paintTextR.height = 0;
        return layoutCL(label, fm, text, icon, paintViewR, paintIconR,
                paintTextR);
    }
}
