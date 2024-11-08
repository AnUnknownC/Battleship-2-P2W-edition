package pruebas;

import modelos.Player;
import modelos.Position;
import modelos.Ship;

public class PruebasBattleShipNormal {
    static Player player = new Player("Bruh");
    static Player opponent = new Player("Bruh");

    // - Prueba de creacion de player y añadir barco
    public static void pruebaJugadorYBarcos(){
        //Ya condicionado para que, en caso de que haya un barco en alguna de las posiciones o que el barco se salga de los limites
        //no añada el barco a la lista de barcos, al momento de colocar los barcos es necesario hacer un ciclo para que se repita
        //la asignacion de barco hasta que se pueda colocar
        player.addShipToPlayer(new Ship(new Position(0, 0), 5, false));
    }

    public static void pruebaOponenteYDaño(){// - Prueba con un oponente, atacar un barco y guardar el daño tanto en el barco
        // como en el mapa ademas de confirmar si ya se habia pegado esa zona
        System.out.println("----------------------------------------");
        opponent.addShipToPlayer(new Ship(new Position(0, 0), 5, false));
        Position possibleHit1 = new Position(4, 4);
        Position possibleHit2 = new Position(0, 0);
        Position possibleHit3 = new Position(0, 3);
        player.attack(opponent, possibleHit1);
        player.attack(opponent, possibleHit2);
        player.attack(opponent, possibleHit2);
        player.attack(opponent, possibleHit3);
    }

    public static void pruebaHundimientoYFinalizar(){
        System.out.println("----------------------------------------");
        opponent.getAllShips().stream().forEach(System.out::println);
        for (Ship ship: opponent.getAllShips()){
            System.out.println("IsSunken: " + ship.isSunken());
            System.out.println("Has player lost: " + opponent.hasLost());
            for (int i = 0; i < ship.getShipLength(); i++) {
                player.attack(opponent, new Position(0, i));
            }
            System.out.println("IsSunken: " + ship.isSunken());
        }
        System.out.println("Has player lost: " + opponent.hasLost());
        opponent.addShipToPlayer(new Ship(new Position(4,4), 3, true));
        System.out.println("Has player lost: " + opponent.hasLost());
    }
}
