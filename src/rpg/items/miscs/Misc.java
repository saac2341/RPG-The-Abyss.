package rpg.items.miscs;
import rpg.items.Item;


/**
 * Creacion de demas objetos.
 */
public abstract class Misc extends Item {
    public Misc(String name){
        super(name);
    }

    public String toString(){
        return "Objeto    "+name+"  Descripcion   "+description+"    puntos "+ price;
    }
}
