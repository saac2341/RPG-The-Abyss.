package rpg.items.miscs;

public abstract class StrengthPotion extends Misc {

    public StrengthPotion(){
        super();
    }

    @Override
    protected void initItem() {
        this.name="Posima de defensa";
        this.description="Aumenta 20 puntos de ataque";
        this.price=300;
    }

    @Override
    public void use() {

    }
}
