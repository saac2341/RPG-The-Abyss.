package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

/**
 * Imagen o fondo de la sección superior de nuestro panel de juego
 */
public class TopPanel extends BackgroundPanel {

    @Override
    protected void init() {
        /**
         * Buscamos la imagen en los directorios
         */
        backgroundImage = new ImageIcon(PictureCache.addImage("topPanel", "panels/MainPanel.jpg"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

    private void createUIComponents() {
        TopPanel topPanel = new TopPanel();
    }

}
