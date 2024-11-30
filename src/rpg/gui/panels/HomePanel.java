package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class HomePanel extends BackgroundPanel{

    /**
     * Imagen o fondo de la sección media de nuestro panel de juego, en este panel se desarrollan las peleas del juego.
     */

    protected void init(){
        /**
         * Imagen de enmedio de la interfas
         */
        backgroundImage=new ImageIcon(PictureCache.addImage("homePanel","panels/TopPanel.jpg"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

    private void createUIComponents(){
        HomePanel homePanel=new HomePanel();
    }
}
