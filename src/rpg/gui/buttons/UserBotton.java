package rpg.gui.buttons;
import rpg.gui.buttons.HoverButtonUI;

public class UserBotton extends BaseButton{
    /*
    Personalizacion de la aparencia de los botones.
     */
    public UserBotton(String text){
        super(text);
        //Agregar los iconos del  aimagen cache.
        setIcon(null);
        setRolloverIcon(null);
        setUI(new HoverButtonUI());
    }

    protected void initIcons(){
    }
}
