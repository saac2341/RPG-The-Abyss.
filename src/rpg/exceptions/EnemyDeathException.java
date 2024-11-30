package rpg.exceptions;
/**
 * Excepción que se lanza cuando un enemigo muere.
 * Puede ser lanzada por la función attack de la clase Player o
 * por la función attack de la clase Enemy.
 */
public class EnemyDeathException extends Exception{
    /*
    Construye al enemigo diciendo que ha muerto
     */
    public EnemyDeathException(){
        super("El enemigo ha muerto");
    }

}
