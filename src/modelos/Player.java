package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.board = new Board();
        this.ships = new ArrayList<>();
    }

    public String getName() {return name;}

    public Board getBoard() {return board;}

    public List<Ship> getAllShips() {return ships;}

    //Añade el barco primero comprobando si ya hay un barco en el lugar con canPlaceShip
    public boolean addShipToPlayer(Ship ship){
        if (board.canPlaceShip(ship)){
            ships.add(ship);
            return true;
        }
        return false;
    }

    // Este metodo revisa que se confirme el golpe al barco del otro jugador
    public boolean attack(Player opponent, Position possibleHit) {
        //Busca en los barcos del oponente para buscar si le pega a alguno
        for (Ship ship: opponent.getAllShips()){
            for (Position position: ship.getHits().keySet()){
                boolean confirmedHit = position.getRow() == possibleHit.getRow() && position.getColumn() == possibleHit.getColumn();
                //Confirma si hay un barco en la posicion
                if(confirmedHit){
                    //Confirma si se le habia golpeado en la zona
                    if (ship.getHits().get(position)){
                        System.out.println("This zone is already damaged");
                        return false;
                    }
                    System.out.println("CONFIRMED STRIKE");
                    ship.getHits().put(position, true);
                    opponent.getBoard().showDamage(position, true);
                    return true;
                }
            }
        }
        System.out.println("MISSED STRIKE");
        opponent.getBoard().showDamage(possibleHit, false);
        return false;
    }

    //Confirma si a alguno de los barcos esta sin hundir
    public boolean hasLost() {
        for (Ship ship: ships){
            if (!ship.isSunken()){
                return false;
            }
        }
        return true;
    }

    //Se usara para que al iniciar el juego los jugadores asignen los barcos como lo deseen
    public void setShipsForGame(int ammountShips){
        Scanner scanner = new Scanner(System.in);
        System.out.println(name);
        for (int i = 0; i < ammountShips; i++) {
            while(true){
                System.out.println("Starter position ship " + (i + 1) + ": ");
                Position starterPos = new Position(scanner.nextInt(), scanner.nextInt());
                System.out.println("Do you want it horizontal(true/false): ");
                boolean isHorizontal = scanner.nextBoolean();
                if (addShipToPlayer(new Ship(starterPos, i + 1, isHorizontal))){
                    break;
                }
            }
        }
    }

    //Como en el codigo original aqui dejare los datasets para no tener que colocar la informacion de los barcos uno por uno.
    public void datosPruebaPlayer1(){
//        addShipToPlayer(new Ship(new Position(2, 2), 6, true));
        addShipToPlayer(new Ship(new Position(5, 5), 2, true));
//        addShipToPlayer(new Ship(new Position(6, 0), 1, true));
//        addShipToPlayer(new Ship(new Position(4, 4), 5, false));
    }

    public void datosPruebaPlayer2(){
//        addShipToPlayer(new Ship(new Position(0, 0), 2, true));
        addShipToPlayer(new Ship(new Position(7, 8), 2, false));
//        addShipToPlayer(new Ship(new Position(0, 7), 3, true));
//        addShipToPlayer(new Ship(new Position(5, 5), 5, true));
    }
}