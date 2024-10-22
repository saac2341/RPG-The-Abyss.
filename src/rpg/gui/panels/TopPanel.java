package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.PictureCache;

import javax.swing.*;

public class TopPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(PictureCache.addImage("topPanel", "panels/statusPanel.png"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

    private void createUIComponents() {
        TopPanel topPanel = new TopPanel();
    }

}