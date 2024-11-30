package rpg.items.miscs;

public abstract class EquipmentAmulet extends Misc {
/*
Creacion de un amuleto
 */
    public EquipmentAmulet(){
        super();
    }

    @Override
    protected void initItem() {
        this.name="Amuleto de equipamiento";
        this.description="Amuleto mágico que aumenta al doble el daño de armas.";
        this.price=3500;
    }

    @Override
    public void use() {

    }
}
