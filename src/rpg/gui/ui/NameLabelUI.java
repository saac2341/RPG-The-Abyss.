package rpg.gui.ui;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * La clase NameLabelUI extiende GameLabelUI, lo que sugiere que es una implementación personalizada para la UI de etiquetas en un juego.
 */
public class NameLabelUI extends GameLabelUI {

    private final BufferedImage[] icons;

    /**
     * Constructor de la clase.
     */
    public NameLabelUI() {
        super(null, null);

        /**
         * Inicializa el array de imágenes.
         */
        icons = new BufferedImage[3];

        /**
         * Carga las imágenes desde el caché de imágenes.
         */
        PictureCache.addImage("name_l", "InterfacePlugins/NameOro/IzN.png"); // Parte izquierda
        PictureCache.addImage("name_c", "InterfacePlugins/NameOro/CN.png");   // Parte central
        PictureCache.addImage("name_r", "InterfacePlugins/NameOro/DeN.png");   // Parte derecha

        /**
         * Asigna las imágenes cargadas al array.
         */
        icons[0] = PictureCache.getImage("name_l");
        icons[1] = PictureCache.getImage("name_c");
        icons[2] = PictureCache.getImage("name_r");
    }

    @Override
    protected void installDefaults(JLabel c) {
        /**
         * Establece la fuente, el color, la posición y alinea el texto.
         */
        c.setFont(UIConstants.LABEL_FONT);
        c.setForeground(Color.BLACK);
        c.setVerticalAlignment(JLabel.CENTER);
        c.setHorizontalAlignment(JLabel.CENTER);
        c.setVerticalTextPosition(JLabel.CENTER);
        c.setHorizontalTextPosition(JLabel.CENTER);

        /**
         * Calcula el ancho del texto y establece el tamaño preferido de la etiqueta.
         */
        FontMetrics metrics = c.getFontMetrics(c.getFont());
        int textWidth = metrics.stringWidth(c.getText());
        c.setPreferredSize(new Dimension(textWidth + 89, 58));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();
        /**
         * Ajusta el texto de la etiqueta para que se ajuste al espacio disponible.
         */
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight());
        int stringWidth = fm.stringWidth(label.getText());
        int textY = paintTextR.y;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /**
         * Dibujan y acomodan las partes del icono en diferentes pociciones.
         */
        g2d.drawImage(icons[0], 0, 0, icons[0].getWidth(), icons[0].getHeight(), c);
        g2d.translate(icons[0].getWidth(), 0);
        g2d.drawImage(icons[1], 0, 0, stringWidth, icons[1].getHeight(), c);
        g2d.translate(stringWidth, 0);
        g2d.drawImage(icons[2], 0, 0, icons[2].getWidth(), icons[2].getHeight(), c);
        g2d.translate(-stringWidth, 0);
        g2d.drawString(clippedText, 0, textY + fm.getAscent());
    }
}
