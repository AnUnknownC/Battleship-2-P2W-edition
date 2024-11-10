package pruebas;

import java.util.ArrayList;

import modelos.Player;
import modelos.Position;

public class PruebasRachas {
     
     private int killStreak;
     private ArrayList<String> streak;

     public PruebasRachas(){
          this.killStreak = 0;
          this.streak = new ArrayList<>();
     }

     public int updateKillStreak(){
          System.out.println(killStreak);
          return killStreak++;  
     }

     public ArrayList<String> getStreak(){
          return streak;
     }

    public void unlockStreak(int killStreak){
          if (killStreak == 4 && !streak.contains("UAV")){
               streak.add("UAV");
          } 
          else if (killStreak == 5 && !streak.contains("AirStrike")){
               streak.add("AirStrike");
               System.out.println("AirStrike Disponible!");
          }
          else if (killStreak == 8 && !streak.contains("Nuke")){
               streak.add("Nuke");
               System.out.println("¡Alerta de nuke, Disponible!");
          }
    }

    public void useUAV(Player opponent){
          if(streak.contains("UAV")){
               System.out.println("Desplegando UAV...");
               opponent.getBoard().display();
               streak.remove("UAV");
          } else {
               System.out.println("No hay suficientes Puntos");
          }
    }

    public void useAirStrike(Player opponent, Position Position){
          if(streak.contains("AirStrike")){
               System.out.println("Usando AirStrike");
               opponent.getBoard().validateCoordinate(Position);
               streak.remove("AirStrike");
          } else {
               System.out.println("No hay suficientes Puntos");
          }
    }

    public void useNuke(Player opponent){
     if(streak.contains("Nuke")){
          System.out.println("Usando Nuke");
          System.out.println("3... 2... 1...");
          for (int i = 0; i<opponent.getBoard().getSize(); i++){
               for (int j = 0; j< opponent.getBoard().getSize(); j++){
                    opponent.attack(opponent, (new Position(i,j)));
               }
          }
     }
    }
}
