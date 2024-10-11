package rpg.items.armors.Armaduras;

import rpg.items.armors.Armaduras.*;
import rpg.items.armors.Armor;

public abstract class Armor1 extends Armor {
    public Armor1(){
        super("Casco");
    }
    protected void initArmor(){
        this.name="Casco";
        this.description="De hierro";
        this.price=10;
    }
}