package rpg.items.armors.Armaduras;

import rpg.items.armors.Armor;

public abstract class Yoroi extends Armor {

    public Yoroi (String name){
        super("Yoroi");
    }

    protected void initArmor(){
        this.name="Yoroi";
        this.description="Armadura samurai antigua.";
        this.price=500;
    }

}
