package rpg.items.miscs;

public class Posion extends Misc{
    public Posion(){
        super("Posima");
    }

    @Override
    protected void initItem() {
        this.name="Posima";
        this.description="Mas 50 de vida";
        this.price=10;
    }

}
