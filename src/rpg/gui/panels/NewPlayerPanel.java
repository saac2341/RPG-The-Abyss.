package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class NewPlayerPanel extends BackgroundPanel {

    @Override
    protected void init() {
        backgroundImage = new ImageIcon(PictureCache.addImage("borderPanel",
                "panels/Guarida.jpg"));
        setDimension(UIConstants.NEW_PLAYER_PANEL_DIMENSION);
    }
}
