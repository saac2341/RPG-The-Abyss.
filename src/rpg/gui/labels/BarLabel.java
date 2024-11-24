package rpg.gui.labels;

import rpg.enums.BarType;
import rpg.gui.ui.BarLabelUI;

import javax.swing.*;

public class BarLabel extends JLabel {

    private int barValue;
    private int maxValue;
    private final BarType type;

    public BarLabel(int value, int maxValue, BarType type){

        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents();
    }

    public void updateBar(int value, int maxValue){

        setMaxValue(maxValue);
        setBarValue(value);
        setUI(new BarLabelUI(type));
        revalidate();
        repaint();
    }

    public void initComponents() {

        setBarValue(barValue);
        setUI(new BarLabelUI(type));
    }

    public void setBarValue(int value){

        this.barValue = value;
        setText(String.format("%d / %d", barValue, maxValue));
    }

    public int getBarValue() {
        return barValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public BarType getType() {
        return type;
    }

}
