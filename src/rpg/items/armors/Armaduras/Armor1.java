package rpg.items.armors.Armaduras;

import rpg.items.armors.Armor;

public abstract class Armor1 extends Armor {
    public Armor1(String name){
        super("Casco");
    }

    protected void initArmor(){
        this.name="Casco";
        this.description="Casco de acero";
        this.price=20;
    }
}
