package rpg.items.armors.Armaduras;

import rpg.items.armors.Armor;

public abstract class CloakOfDeath extends Armor {
    public CloakOfDeath (String name){
        super("Manto de la muerte");
    }

    protected void initArmor(){
        this.name="Manto de la muerte";
        this.description="Túnica vieja y negra que en los momentos más difíciles puede ayudar evadir hasta la propia muerte.";
        this.price=1600;
    }
}
