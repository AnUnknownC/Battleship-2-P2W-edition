package pruebas;

import modelos.Player;
import modelos.Position;

import java.util.Scanner;

public class PruebasRachas {
    static Player currentPlayer = new Player("Bruh");
    static Player opponent = new Player("Dud");

    public static void PruebasContadorRacha() {
        currentPlayer.datosPruebaPlayer1();
        Position hit = new Position(2, 2);
        currentPlayer.attack(currentPlayer, hit);
        System.out.println(currentPlayer.getStreak().getKillStreak());
    }

    public static void PruebasDisponibilidadRachas() {
        currentPlayer.datosPruebaPlayer1();
        for (int i = 0; i < 8; i++) {
            currentPlayer.attack(currentPlayer, new Position(i, 0));
        }
    }

    public static void PruebasAccesoRachas() {
        opponent.datosPruebaPlayer2();
//        currentPlayer.getStreak().useUAV(opponent);
//        currentPlayer.getStreak().useAirStrike(opponent);
//        currentPlayer.getStreak().useNuke(opponent);
//        opponent.getBoard().display();
    }

    public static void PruebaEntradaInterfaz(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are on a streak, this are the available options: ");
        currentPlayer.getStreak().getAvailableStreaks().stream()
                .map(option -> "- " + option).forEach(System.out::println);
        System.out.println("Type the option's name to use (if not then just type Ignore): ");
        String choice = scanner.next();
        if (choice.toUpperCase().equals("UAV")){
            currentPlayer.getStreak().useUAV(opponent);
        } else if (choice.toUpperCase().equals("AIRSTRIKE")){
            currentPlayer.getStreak().useAirStrike(opponent);
        }  else if (choice.toUpperCase().equals("NUKE")){
            currentPlayer.getStreak().useNuke(opponent);
        }  else if (choice.toUpperCase().equals("IGNORE")){
            System.out.println("Roger, continue the attack");
        } else {
            System.out.println("Wrong option, try again");
        }
        System.out.println(opponent.hasLost());
    }
}
