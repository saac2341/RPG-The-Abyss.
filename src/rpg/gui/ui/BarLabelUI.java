package rpg.gui.ui;

import rpg.enums.BarType;
import rpg.gui.UIConstants;
import rpg.gui.labels.BarLabel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * La clase BarLabelUI extiende BasicLabelUI para personalizar la apariencia de un JLabel
 * que representa una barra con un ícono y un valor.
 */
public class BarLabelUI extends BasicLabelUI {

    private final BarType type;

    /**
     * Constructor de BarLabelUI que inicializa el tipo de barra.
     */
    public BarLabelUI(BarType type) {
        this.type = type;
    }

    /**
     * Instala las configuraciones predeterminadas para el JLabel.
     */
    @Override
    protected void installDefaults(JLabel c) {

        c.setOpaque(false);
        c.setForeground(Color.WHITE);
        c.setFont(UIConstants.BAR_LABEL_FONT);
        c.setVerticalAlignment(JLabel.BOTTOM);
        c.setVerticalTextPosition(JLabel.BOTTOM);
        c.setHorizontalAlignment(JLabel.RIGHT);
        c.setHorizontalTextPosition(JLabel.RIGHT);
    }

    /**
     * Devuelve el tamaño preferido del JLabel.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Devuelve el tamaño mínimo del JLabel.
     */
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Devuelve el tamaño máximo del JLabel.
     */
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Dibuja el texto habilitado en el JLabel.
     */
    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int textMiddle = g.getFontMetrics(g.getFont()).stringWidth(s) / 2;
        g.drawString(s, textX-textMiddle-5, textY+3);
    }

    /**
     * Dibuja el JLabel en el componente.
     * Dibuja el ícono, el contenedor y la barra de progreso según los valores proporcionados.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        BarLabel barLabel = (BarLabel) c;
        BufferedImage icon = type.getIcon();
        BufferedImage container = type.getContainer();
        BufferedImage bar = type.getBar();
        int barValue = getBarValue(barLabel);
        int maxValue = getMaxBarValue(barLabel);
        int iconX = 0;
        int iconY = 0;
        int iconWidth = UIConstants.BAR_ICON.width;
        int iconHeight = UIConstants.BAR_ICON.height;
        int displayX = UIConstants.BAR_ICON.width - 2;
        int displayY = iconY + 5;
        int displayWidth = UIConstants.BAR_DISPLAY.width;
        int displayHeight = UIConstants.BAR_DISPLAY.height;
        int barWidth = (int) ((double) barValue / maxValue * 157);
        int barHeight = 17;
        int barX = iconWidth + 9;
        int barY = iconY + 18;
        g2d.drawImage(icon, iconX, iconY, iconWidth, iconHeight, null);
        g2d.drawImage(container, displayX, displayY, displayWidth, displayHeight, null);
        g2d.drawImage(bar, barX, barY, barWidth, barHeight, null);
        super.paint(g, c);
    }

    private int getBarValue(JLabel c) {
        return ((BarLabel) c).getBarValue();
    }

    private int getMaxBarValue(JLabel c) {
        return ((BarLabel) c).getMaxValue();
    }

    /**
     * Calcula el ancho total de la barra, que incluye el tamaño del ícono
     * y el tamaño de la visualización de la barra.
     */
    private Dimension getBarWidth() {
        Dimension iconSize = UIConstants.BAR_ICON;
        Dimension displaySize = UIConstants.BAR_DISPLAY;
        int width = iconSize.width + displaySize.width;
        return new Dimension(width, iconSize.height + 5);
    }

}
