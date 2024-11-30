package rpg.gui.buttons;
import rpg.gui.ui.HoverButtonUI;

public class UserBotton extends BaseButton{
    /**
     * Personalizacion de la aparencia de los botones.
     */
    public UserBotton(String text){
        super(text);
        /**
         * Agrega las imagenes de los botones.
         */
        setIcon(null);
        setRolloverIcon(null);
        setUI(new HoverButtonUI());
    }

    protected void initIcons(){
    }
}
