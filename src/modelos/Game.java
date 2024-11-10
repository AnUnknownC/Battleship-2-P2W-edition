package modelos;

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
        System.out.println("Welcome to Battleship!");
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

        player1.datosPruebaPlayer1();
        player2.datosPruebaPlayer2();

        Player currentPlayer = player1;
        Player opponent = player2;

        while(!player1.hasLost() && !player2.hasLost()){
            Position possibleHit = new Position(0,0);
            Position airStrikeHit = new Position(0,0);
            while(true){
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Turno de: " + currentPlayer.getName());
                    currentPlayer.getBoard().display();
                    Scanner choice = new Scanner(System.in);
                    System.out.println("Type the position to attack (Row - Column)");
                    possibleHit = new Position(scanner.nextInt(), scanner.nextInt());
                    if (opponent.getBoard().validateCoordinate(possibleHit)){
                        
                        /// -------------------- Esto lo añadi -------------------- ///
                        if (!currentPlayer.getUseStreaks().getStreak().isEmpty()) {
                            System.out.println("Desea Usar una racha? (UAV, AirStrike, Nuke) (si/no)");
                            String useStreak = scanner.next();
                            
                            if (useStreak.equalsIgnoreCase("si")) {
                                System.out.println("Cual desea usar? (UAV/AirStrike/Nuke)");
                                String chooseStreak = scanner.next();
    
                                if (chooseStreak.equalsIgnoreCase("UAV")) {
                                    System.out.println("-----------------------------");
                                    currentPlayer.getUseStreaks().useUAV(opponent);
                                    System.out.println("-----------------------------");
                           
                                } else if (chooseStreak.equalsIgnoreCase("AirStrike")) {

                                    System.out.println("Ingrese las coordenadas (FILA COLUMNA): ");
                                    airStrikeHit = new Position(scanner.nextInt(),scanner.nextInt());
                                    // System.out.println("HOLA MUNDO");
                                    currentPlayer.getUseStreaks().useAirStrike(opponent, new Position(airStrikeHit));

                                } else if (chooseStreak.equalsIgnoreCase("Nuke")) {
                                    currentPlayer.getUseStreaks().useNuke(opponent);
                                    currentPlayer.getBoard().display();
                                } else {
                                    System.out.println("Recompensa Invalida");
                                }
                            }
                        } else {
                            System.out.println("----------------------------------------- "); 
                        }

                        /// ----------------------------------------------------------------- ///
                        
                        break;
                    }else {
                        System.out.println("Invalid coordinate, try again");
                    }
                    
                }catch (InputMismatchException e){
                    System.out.println("Invalid coordinate, try again");
                }
            }
            currentPlayer.attack(opponent, possibleHit);

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }
        System.out.println("GAME OVER!! " + opponent.getName() + " wins");
    }
}
