package rpg.gui.ui;

import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.*;

public class UserHoverUI extends HoverButtonUI {

    private final int staticWidth = 180;

    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        /**
         * Establecemos el borde del botón.
         */
        b.setForeground(Color.WHITE);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {

        return new Dimension(staticWidth, 48);
    }

    protected void initParts() {
        /**
         * Inicializamos los arreglos de imágenes.
         */
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        /**
         * Agregamos las imágenes a la caché.
         */
        PictureCache.addImage("actionLeftSide", "ButtonParts/BotonI.png");
        PictureCache.addImage("actionCenterSide", "ButtonParts/BotonC.png");
        PictureCache.addImage("actionRightSide", "ButtonParts/BotonD.png");
        PictureCache.addImage("actionHoverLeftSide", "ButtonParts/BotonI.png");
        PictureCache.addImage("actionHoverCenterSide", "ButtonParts/BotonC.png");
        PictureCache.addImage("actionHoverRightSide", "ButtonParts/BotonD.png");
        /**
         * Obtenemos las imágenes de la caché y las almacenamos en los arreglos correspondientes.
         */
        parts[0] = PictureCache.getImageIcon("actionLeftSide");
        parts[1] = PictureCache.getImageIcon("actionCenterSide");
        parts[2] = PictureCache.getImageIcon("actionRightSide");
        partsHover[0] = PictureCache.getImageIcon("actionHoverLeftSide");
        partsHover[1] = PictureCache.getImageIcon("actionHoverCenterSide");
        partsHover[2] = PictureCache.getImageIcon("actionHoverRightSide");
    }

    /**
     * Recibe como parámetros un objeto Graphics2D y un array de ImageIcon que representan las partes del botón.
     */
    protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {

        /**
         * Dibuja la primera parte del botón.
         */
        g2d.drawImage(parts[0].getImage(), 0, 0, null);
        /**
         * Translada el sistema de coordenadas para dibujar la segunda parte.
         */
        g2d.translate(27, 0);
        /**
         * Dibuja la segunda parte del botón.
         */
        g2d.drawImage(parts[1].getImage(), 0, 0, staticWidth - 54, height, null);
        /**
         * Translada el sistema de coordenadas a la derecha para dibujar la tercera parte.
         */
        g2d.translate(staticWidth - 54, 0);
        /**
         * Dibuja la tercera parte del botón en la posición actual.
         */
        g2d.drawImage(parts[2].getImage(), 0, 0, null);
        /**
         * Restaura el sistema de coordenadas a su posición original, trasladando hacia la izquierda.
         */
        g2d.translate(-staticWidth + width + 54, 0);
    }
}
