package principal;

import modelos.Game;
import modelos.Player;
import pruebas.PruebasBattleShipNormal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
//        PruebasBattleShipNormal.pruebaJugadorYBarcos();
//        PruebasBattleShipNormal.pruebaOponenteYDaño();
//        PruebasBattleShipNormal.pruebaHundimientoYFinalizar();

        Scanner scanner = new Scanner(System.in);
        Game game = new Game("JDRO", "Bruh");
        game.start();

//        //Para cuando se inicie si se quiere cambiar los nombres
//        System.out.println("Player 1's username: ");
//        String player1 = scanner.next();
//        System.out.println("Player 2's username: ");
//        String player2 = scanner.next();
//        game = new Game(player1, player2);
    }
}
