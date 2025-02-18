package rpg.factory;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
/*
Esta clase se encarga de generar y mandar los enemigos
para que peleen con el jugador.
 */
public class EnemyFactory {
    private static final Random random = new Random();

    public static Enemy getEnemy(EnemyType type){
        Enemy enemyInstance;
        Set<Class<? extends Enemy>> enemyClasses;
        List<Class<? extends Enemy>> classList;
        //Configurar reflectos para buscar las clases.
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));
        //Obtenr las clases de Enemy.
        enemyClasses=reflections.getSubTypesOf(Enemy.class);
        //Filtrar las clases a solo obtener de tipo basico.
        classList =filterList(enemyClasses.stream().toList(), type);

        try {
            int randomIndex;
            if (classList!=null){
                randomIndex = random.nextInt(classList.size());
                enemyInstance=classList.get(randomIndex).getDeclaredConstructor()
                        .newInstance();
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            return null;
        }
        return enemyInstance;
    }

    private static List<Class<? extends Enemy>> filterList(List<Class<? extends
            Enemy>> classList, EnemyType enemyType){
        Enemy enemy;
        List<Class<? extends Enemy>> classListFilted=new ArrayList<>();
        for (Class<? extends Enemy> enemyClass : classList){
            try {
                enemy = enemyClass.getDeclaredConstructor().newInstance();
                if (enemy.getType() == enemyType){
                    classListFilted.add(enemyClass);
                }
            }catch (Exception e){
                return null;
            }
        }
        return classListFilted;
    }
}
