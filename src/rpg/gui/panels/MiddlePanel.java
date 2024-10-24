package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(PictureCache.addImage("midPanel", "panels/Fondo.jpg"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}
