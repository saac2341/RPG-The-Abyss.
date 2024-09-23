package rpg;
import rpg.enums.Stats;
import rpg.entities.Player;
import rpg.entities.Enemy;
import javax.swing.*;
import java.lang.NullPointerException;
import java.awt.*;


public class Game {
        private static Player player;
        private static Enemy enemy;

        /**
         * Ejecutos del programa del juego
         */
        public static void main(String[] args){

            player = new Player("Mago");
            enemy = new Enemy("Goblin");
            Game.startGame();
        }

        /**
         * Analiza quien a muerto en el juego
         */
        public static void startGame() {
            while (player.isAlive() && enemy.isAlive()) {
                player.attack(enemy);
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            if (player.isAlive()) {
                JOptionPane.showMessageDialog(null, "Tu has matado al enemigo ");
            } else {
                JOptionPane.showMessageDialog(null,"Has perdido, el enemigo te a matado");
            }
        }
    }
