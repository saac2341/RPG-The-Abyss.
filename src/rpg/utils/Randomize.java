package rpg.utils;
/*
Esta clase se encarga de generar vlaores aleatorios
 */
public interface Randomize {
    static int getRandomInt(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }

    static boolean getRandomBolean(){
        return Math.random()<0.5;
    }
}
