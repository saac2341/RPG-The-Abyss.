package rpg.items.miscs;

public abstract class DefensePotion extends Misc {

    public DefensePotion(){
        super("Posima de defensa");
    }

    @Override
    protected void initItem() {
        this.name="Posima de defensa";
        this.description="Aumenta 10 puntos de defensa";
        this.price=100;
    }

}
