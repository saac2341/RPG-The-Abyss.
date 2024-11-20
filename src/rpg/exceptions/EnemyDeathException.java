package rpg.exceptions;

public class EnemyDeathException extends Exception{

    public EnemyDeathException(){
        super("El enemigo ha muerto");
    }

}
