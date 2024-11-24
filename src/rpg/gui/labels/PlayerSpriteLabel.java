package rpg.gui.labels;

//Impportar clases de la cache al mago.
import rpg.utils.cache.PictureCache;

import java.awt.*;

public class PlayerSpriteLabel extends PortraitLabel{
    public PlayerSpriteLabel(){
        super();
    }
    //Agregar la imagen de al panel del jugador.
    public void initComponents(){
        PictureCache.addImage("playerSprite","Player/MagoF.png");
        icon = PictureCache.getImageIcon("playerSprite");
        setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
        setIcon(icon);
    }
}
