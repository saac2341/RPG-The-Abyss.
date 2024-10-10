package rpg.items.armors.Armaduras;

import rpg.items.armors.Armor;

public abstract class HeavenlyArmor extends Armor {
    public HeavenlyArmor(String name){
        super("Armadura celestial");
    }

    protected void initArmor(){
        this.name="Armadura celestial";
        this.description="Armadura y forjada por los dioses con una gran resistencia y protección.";
        this.price=5000;
    }

}
