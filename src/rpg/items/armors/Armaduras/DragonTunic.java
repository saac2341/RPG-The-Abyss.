package rpg.items.armors.Armaduras;

import rpg.items.armors.Armor;

public abstract class DragonTunic extends Armor {

    public DragonTunic (String name){
        super("Tunica de dragon");
    }

    protected void initArmor(){
        this.name="Tunica de dragon";
        this.description="Tunica cubierta de escamas de dragon resistente a ataques de fugo.";
        this.price=900;
    }

}
