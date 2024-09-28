package rpg;
import rpg.entities.Player;
import rpg.entities.enemies.*;
import javax.swing.*;
import rpg.utils.Randomize;

public class Game {
        private final Player player;
        private final Enemy enemy;

        /**
         * Ejecutos del programa del juego
         */
        public static void main(String[] args){
            Game game=new Game();
            game.startGame();
        }

        /**
         * Creacion de los objetos
         */
        public Game() {
            this.player = new Player("Mago");
            int enemyType= Randomize.getRandomInt(1,4);
            this.enemy = switch (enemyType){
                case 1 -> new Destroyer();
                case 2 -> new TheButcherOfSouls();
                case 3 -> new IntermediateLince();
                case 4 -> new MoleMan();
                case 5 -> new Hermit();
                default -> new Enemy();
            };
        }

        /**
         * Analiza quien ha muerto en el juego
         */
        public void startGame() {
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
