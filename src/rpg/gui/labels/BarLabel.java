package rpg.gui.labels;

import rpg.enums.BarType;
import rpg.gui.ui.BarLabelUI;

import javax.swing.*;

/**
 * La clase BarLabel extiende JLabel y representa una barra que muestra
 * un valor actual en relación con un valor máximo, junto con su tipo.
 */
public class BarLabel extends JLabel {
    private int barValue;
    private int maxValue;
    private final BarType type;

    /**
     * Constructor de BarLabel que inicializa la barra con un valor actual,
     * un valor máximo y un tipo específico.
     */
    public BarLabel(int value, int maxValue, BarType type){
        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents();
    }

    /**
     * Actualiza el valor actual y el valor máximo de la barra,
     * y refresca la interfaz de usuario.
     */
    public void updateBar(int value, int maxValue){
        setMaxValue(maxValue);
        setBarValue(value);
        setUI(new BarLabelUI(type));
        revalidate();
        repaint();
    }

    /**
     * Inicializa los componentes de la barra, incluyendo la configuración
     * del valor actual y la UI.
     */
    public void initComponents() {

        setBarValue(barValue);
        setUI(new BarLabelUI(type));
    }

    /**
     * Establece el valor actual de la barra y actualiza el texto mostrado.
     */
    public void setBarValue(int value){

        this.barValue = value;
        setText(String.format("%d / %d", barValue, maxValue));
    }

    /**
     * Obtiene el valor actual de la barra.
     */
    public int getBarValue() {
        return barValue;
    }
    /**
     * Obtiene el valor máximo de la barra.
     */
    public int getMaxValue() {
        return maxValue;
    }
    /**
     * Establece el valor máximo de la barra.
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    /**
     * Obtiene el tipo de la barra.
     */
    public BarType getType() {
        return type;
    }

}
