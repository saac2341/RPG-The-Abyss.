package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;
import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.*;

/**
 * La clase PortraitLabel extiende JLabel para representar un retrato
 * con un ícono que se carga desde un recurso de imagen.
 */
public class PortraitLabel extends JLabel {

    protected ImageIcon icon;

    /**
     * Constructor de PortraitLabel que inicializa los componentes
     * y establece la interfaz de usuario personalizada.
     */
    public PortraitLabel() {
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(), icon));
    }

    /**
     * Inicializa los componentes del PortraitLabel, incluyendo la carga
     * del ícono desde el caché de imágenes y la configuración del tamaño preferido.
     */
    public void initComponents() {
        PictureCache.addImage("portrait", "Player/Icono.png");
        icon = PictureCache.getImageIcon("portrait");
        setPreferredSize(
                new Dimension(icon.getIconWidth(),
                        icon.getIconHeight()));
        setIcon(icon);
    }

    /**
     * Dibuja el componente en el área del JLabel.
     */
    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(icon.getImage(), 0, 0,
                getPreferredSize().width,
                getPreferredSize().height, this);
    }
}