package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

public class FilesPanel extends BackgroundPanel{
     protected void init(){
         backgroundImage=new ImageIcon(PictureCache.addImage("BorderPanel",
                 ""));
         setDimension(UIConstants.FILES_PANEL_DIMENSION);
     }
}
