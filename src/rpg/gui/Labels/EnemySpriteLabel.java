package rpg.gui.Labels;

import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;
import rpg.utils.cache.PictureCache;
import rpg.gui.ui.GameLabelUI;
import javax.swing.*;
import java.awt.*;

/*
Clase para mostar al enemigo.
 */
public class EnemySpriteLabel extends JLabel {
    ImageIcon icon;
    Enemy enemy;

    public EnemySpriteLabel(Enemy enemy){
        this.enemy=enemy;;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }

    public void initComponents(){
        icon=enemy.getSprite();
        setPreferredSize(getMinimumSize());
        setSize(getMinimumSize());
        setIcon(icon);
    }
     private Dimension getMinimusSize(){
        if (icon.getIconHeight()>350 || icon.getIconHeight()>184){
            icon=new ImageIcon(icon.getImage().getScaledInstance(450,250,Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(),icon.getIconHeight());
     }
}
