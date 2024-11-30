package rpg.exceptions;
/*
Se utliza para decir que el inventario esta lleno
 */
public class InventoryFullException extends Exception {
    /*
    El constructor dice que esta lleno.
     */
    public InventoryFullException(){
      super("El inventario esta lleno");
    }
}
