package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;

/**
 * Imagen o fondo de la pantalla de carga.
 */

public class FilesPanel extends BackgroundPanel{
     protected void init(){
         /**
          * Busqueda la imagen de manera directa a traves de directorios
          */
         backgroundImage=new ImageIcon(PictureCache.addImage("BorderPanel",
                 "panels/ImagenFondo.jpg"));
         setDimension(UIConstants.FILES_PANEL_DIMENSION);
     }
}
