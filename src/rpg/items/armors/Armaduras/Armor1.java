package rpg.items.armors.Armaduras;

import rpg.enums.ArmorType;
import rpg.items.armors.Armor;

public class Armor1 extends Armor {
    public Armor1(){
        super("Casco");
    }
    protected void initArmor(){
        this.name="Casco";
        this.description="Casco de acero";
        this.price=20;
    }
}
