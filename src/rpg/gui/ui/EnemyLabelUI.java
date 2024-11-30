package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
Mostra de manera correcta los sprites.
 */
public class EnemyLabelUI extends BasicLabelUI {
    ImageIcon icon;
    public EnemyLabelUI(ImageIcon icon){
        this.icon=icon;
    }
    protected void installDefaults(JLabel c){
        c.setOpaque(false);
        c.setBorder(null);
    }
    public void pain(Graphics g, JComponent c){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(icon.getImage(),0,0,icon.getIconWidth(),
                icon.getIconHeight(),c);
    }
}