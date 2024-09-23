package rpg;
import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import javax.swing.*;


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
