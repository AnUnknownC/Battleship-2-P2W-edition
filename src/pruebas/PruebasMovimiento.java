package pruebas;

import modelos.Player;
import modelos.Position;
import modelos.Ship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebasMovimiento {
    static Player player1 = new Player("Bruh");
    static Player player2 = new Player("Dud");

    public static void pruebaCambioTableroYArreglo(){
        player1.datosPruebaPlayer1();
        player1.attack(player1, new Position(4, 2));
        player1.getBoard().display();
        Ship shipToChange;
        Position newPosition;
        Boolean isHorizontal;
        while(true){
            try {
                System.out.println("Select the ship to move: ");
                for (int i = 0; i < player1.getAllShips().size(); i++) {
                    System.out.println((i + 1) + ". Ship in " + player1.getAllShips().get(i).getStartPosition());
                }
                Scanner scanner = new Scanner(System.in);
                shipToChange = player1.getAllShips().get(scanner.nextInt() - 1);
                System.out.println("Type the new position to place the ship (Row - column): ");
                newPosition = new Position(scanner.nextInt(), scanner.nextInt());
                System.out.println("Would you prefer to place it horizontally? (true/false): ");
                isHorizontal = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e){
                System.out.println("Incorrect option, try again");
            } catch (IndexOutOfBoundsException e){
                System.out.println("Incorrect option, try again");
            }
        }
        player1.getBoard().moveShip(shipToChange, newPosition, isHorizontal);
        player1.getBoard().display();
    }

    public static void pruebaIntercambiarValores(){
        player1.datosPruebaPlayer1();
        Ship ship = new Ship(new Position(0, 5), 2, false);
        player1.attack(player1, new Position(2, 2));
        System.out.println(player1.getAllShips().get(0));
        player1.getAllShips().get(0).changeValues(ship);
        System.out.println(player1.getAllShips().get(0));
    }
}
