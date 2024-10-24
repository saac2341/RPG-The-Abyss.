package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class HomePanel extends BackgroundPanel{

    protected void init(){
        //Imagen de enmedio de la interfas
        backgroundImage=new ImageIcon(PictureCache.addImage("homePanel","panels/TopPanel.jpg"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }

    private void createUIComponents(){
        HomePanel homePanel=new HomePanel();
    }
}
