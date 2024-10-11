package rpg.items.miscs;
import rpg.items.Item;

/**
 * Creation de demás objetos.
 */
public abstract class Misc extends Item {
    public Misc(String name){
        super(name);
    }

    public String toString(){
        return "Objeto    "+name+"  Description   "+description+"    puntos "+ price;
    }
}
