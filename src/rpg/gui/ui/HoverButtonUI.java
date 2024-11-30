package rpg.gui.ui;

import rpg.utils.cache.FontCache;
import rpg.utils.cache.PictureCache;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * La clase HoverButtonUI extiende BasicButtonUI para personalizar la apariencia y el comportamiento de un botón.
 */
public class HoverButtonUI extends BasicButtonUI {
    /**
     * Ancho del botón.
     */
    protected int width;
    /**
     * Altura del botón.
     */
    protected int height;
    /**
     * Arreglo que almacena las partes del botón en su estado normal.
     */
    protected ImageIcon[] parts;
    /**
     * Arreglo que almacena las partes del botón en su estado hover.
     */
    protected ImageIcon[] partsHover;
    /**
     * Dimensión del botón.
     */
    private Dimension d;

    /**
     * Instala las configuraciones predeterminadas para el botón.
     * Inicializa las partes del botón y configura propiedades como fuente, color y cursor.
     */
    @Override
    protected void installDefaults(AbstractButton b) {
        initParts();
        /**
         * Configura la fuente, color y otras propiedades del botón.
         */
        b.setFont(FontCache.addFont("Retron2000", "fonts/retron2000/Retron2000.ttf").deriveFont(22.5f));
        b.setForeground(Color.BLACK);
        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setIconTextGap(0);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        /**
         * Calcula el ancho y la altura del botón basado en el texto.
         */
        String text = b.getText();
        this.width = b.getFontMetrics(b.getFont()).stringWidth(text) + 5;
        this.height = 48;
    }

    /**
     * Devuelve el tamaño preferido del botón.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(Math.max(width + 54, 84), 48);
    }

    /**
     * Devuelve el tamaño máximo del botón.
     */
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Devuelve el tamaño mínimo del botón.
     */
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Inicializa las partes del botón en sus estados normal y hover.
     */

    private void initParts() {
        parts = new ImageIcon[3]; // Inicializa el arreglo para las partes normales.
        partsHover = new ImageIcon[3]; // Inicializa el arreglo para las partes hover.
        /**
         * Agrega las imágenes a la caché.
         */
        PictureCache.addImage("userLeftSide", "ButtonParts/BotonI.png");
        PictureCache.addImage("userCenterSide", "ButtonParts/BotonC.png");
        PictureCache.addImage("userRightSide", "ButtonParts/BotonD.png");
        PictureCache.addImage("userHoverLeftSide", "ButtonParts/BotonI.png");
        PictureCache.addImage("userHoverCenterSide", "ButtonParts/BotonC.png");
        PictureCache.addImage("userHoverRightSide", "ButtonParts/BotonD.png");
        /**
         * Obtiene las imágenes de la caché y las almacena en los arreglos correspondientes.
         */
        parts[0] = PictureCache.getImageIcon("userLeftSide");
        parts[1] = PictureCache.getImageIcon("userCenterSide");
        parts[2] = PictureCache.getImageIcon("userRightSide");
        partsHover[0] = PictureCache.getImageIcon("userHoverLeftSide");
        partsHover[1] = PictureCache.getImageIcon("userHoverCenterSide");
        partsHover[2] = PictureCache.getImageIcon("userHoverRightSide");
    }

    /**
     * Dibuja el botón en el componente.
     * Cambia la apariencia del botón según si el mouse está sobre él (hover).
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        /**
         * Activa el antialiasing para un mejor renderizado de gráficos.
         */
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /**
         * Determina qué partes del botón dibujar según si el mouse está sobre el botón.
         */
        ImageIcon[] images = button.getModel().isRollover() ? partsHover : parts;
        /**
         * Dibuja las partes del botón.
         */
        drawButtonParts(g2d, images);
        /**
         * Ajusta la posición para dibujar el texto.
         */
        g2d.translate(-width - 30, 0);
        g2d.setColor(Color.WHITE); // Establece el color del texto a blanco.
        super.paint(g2d, c);
    }

    /**
     * Dibuja las partes del botón utilizando el objeto Graphics2D.
     */
    private void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {
        g2d.drawImage(parts[0].getImage(), 0, 0, 27, height, null);
        g2d.translate(27, 0);
        g2d.drawImage(parts[1].getImage(), 0, 0, width, height, null);
        g2d.translate(width, 0);
        g2d.drawImage(parts[2].getImage(), 0, 0, 27, height, null);
    }
}
