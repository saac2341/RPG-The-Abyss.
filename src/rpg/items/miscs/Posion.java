package rpg.items.miscs;

public class Posion extends Misc {
    public Posion(){
        super();
    }

    @Override
    public void use() {

    }

    @Override
    protected void initItem() {
        this.name="Posima";
        this.description="Mas 50 de vida";
        this.price=10;
    }

}
