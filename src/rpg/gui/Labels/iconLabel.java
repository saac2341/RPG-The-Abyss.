package rpg.gui.Labels;

import rpg.gui.ui.GameLabelUI;

import javax.swing.*;
import java.awt.*;

public class iconLabel extends JLabel {
    protected ImageIcon icon;
    public iconLabel(ImageIcon icon){
        this.icon=icon;
        setIcon(icon);
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(),icon));
    }
    public void initComponents(){
        setPreferredSize(new Dimension(icon.getIconWidth(),
                icon.getIconHeight()));
    }
}
