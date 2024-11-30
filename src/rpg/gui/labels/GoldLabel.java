package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.*;

/**
 * La clase GoldLabel extiende PortraitLabel para representar una etiqueta
 * que muestra la cantidad de oro en la interfaz de usuario.
 */
public class GoldLabel extends PortraitLabel {
    /**
     * Constructor de GoldLabel que inicializa la etiqueta con la cantidad
     * de oro y configura su apariencia.
     */
    public GoldLabel(int gold) {
        super();
        setText(String.format("%d G", gold));
        setFont(UIConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f));
        setForeground(Color.BLACK);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }
    /**
     * Inicializa los componentes del GoldLabel, incluyendo la carga
     * del ícono que representa el oro y el tamaño preferido de la etiqueta.
     */
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
