package rpg.exceptions;
/*
Excepcion  para los items que no son encontrados.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(){
        super("Artículo no encontrado");
    }
}
