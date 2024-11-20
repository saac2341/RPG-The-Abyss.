package rpg.exceptions;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(){
        super("Artículo no encontrado");
    }
}
