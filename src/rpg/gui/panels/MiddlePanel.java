package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

/**
 * Imagen o fondo de la sección inferior de nuestro panel de juego, el nombre de la clase dice panel medio sin embargo por errores en la comunicación de equipo y para evitar consumo de tiempo se quedó así XD.
 */

public class MiddlePanel extends BackgroundPanel {

    @Override
    protected void init() {
        /**
         * Buscamos la imagen por ahora directamente en los directorios
         */
        backgroundImage = new ImageIcon(PictureCache.addImage("midPanel", "panels/Fondo.jpg"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}
