package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.*;

public class GoldLabel extends PortraitLabel {

    public GoldLabel() {
        super();
        setFont(UIConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f));
        setForeground(Color.BLACK);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }

    @Override
    public void initComponents() {
        PictureCache.addImage("gold", "InterfacePlugins/NameOro/OroP2.png");
        icon = PictureCache.getImageIcon("gold");
        setPreferredSize(new Dimension(
                icon.getIconWidth(), icon.getIconHeight()));
        setIcon(icon);
        setText("1000");
    }
}
