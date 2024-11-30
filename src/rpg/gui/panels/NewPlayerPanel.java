package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

/**
 * Imprime una imagen del personaje de nuestro juego en la pantalla de nueva partida para que el usuario se familiarice con este.
 */

public class NewPlayerPanel extends BackgroundPanel {

    @Override
    protected void init() {
        /**
         * Busqueda la imagen de manera directa a traves de directorios
         */
        backgroundImage = new ImageIcon(PictureCache.addImage("borderPanel",
                "panels/Guarida.jpg"));
        setDimension(UIConstants.NEW_PLAYER_PANEL_DIMENSION);
    }
}
