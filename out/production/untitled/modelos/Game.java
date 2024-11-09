package modelos;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void start() {
//        Todo lo que esta comentareado aqui es para un juego real en el que se preguntara cuantos barcos quieren los jugadores y se les
//         dira para que asignen los barcos uno a uno
//        int ammountShips;
//        //Cantidad de barcos con los que se va a jugar la partida, maximo 5
//        while(true){
//            System.out.println("How many ships do you want to use for both players (max 5): ");
//            Scanner scanner = new Scanner(System.in);
//            ammountShips = scanner.nextInt();
//            if (ammountShips <= 5){
//                break;
//            }else {
//                System.out.println("Too many ships, keep in mind that the max is 5");
//            }
//        }

        //Se le permite al jugador asignar los barcos
//        player1.setShipsForGame(ammountShips);
//        player2.setShipsForGame(ammountShips);

        //Se asignan los datasets para no colocarlos manualmente
        player1.datosPruebaPlayer1();
        player2.datosPruebaPlayer2();

        Player currentPlayer = player1;
        Player opponent = player2;
        System.out.println("Welcome to Battleship!");
        while(!player1.hasLost() && !player2.hasLost()){
            Position possibleHit;
            while(true){
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Turn of: " + currentPlayer.getName());
                    currentPlayer.getBoard().display();
                    System.out.println("What do you want to do: \n1. Attack \n2. Move ship");
                    int choice = scanner.nextInt();
                    if (choice == 1){
                        System.out.println("Type the position to attack (Row - Column)");
                        possibleHit = new Position(scanner.nextInt(), scanner.nextInt());
                        if (opponent.getBoard().validateCoordinate(possibleHit)){
                            currentPlayer.attack(opponent, possibleHit);
                            break;
                        }else {
                            System.out.println("Invalid coordinate, try again");
                        }
                    }
                    else if (choice == 2) {
                        Ship shipToChange;
                        Position newPosition;
                        Boolean isHorizontal;
                        while(true){
                            System.out.println("Select the ship to move: ");
                            for (int i = 0; i < currentPlayer.getAllShips().size(); i++) {
                                System.out.println((i + 1) + ". Ship in " + currentPlayer.getAllShips().get(i).getStartPosition());
                            }
                            shipToChange = currentPlayer.getAllShips().get(scanner.nextInt() - 1);
                            System.out.println("Type the new position to place the ship (Row - column): ");
                            newPosition = new Position(scanner.nextInt(), scanner.nextInt());
                            System.out.println("Would you prefer to place it horizontally? (true/false): ");
                            isHorizontal = scanner.nextBoolean();
                            if (currentPlayer.getBoard().moveShip(shipToChange, newPosition, isHorizontal)){
                                break;
                            }
                        }
                        break;
                    }  else {
                        System.out.println("Not available option, try again");
                    }
                } catch (InputMismatchException | IndexOutOfBoundsException e){
                    System.out.println("Incorrect input, try again");
                }
            }

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }
        System.out.println("GAME OVER!! " + opponent.getName() + " wins");
    }
}
