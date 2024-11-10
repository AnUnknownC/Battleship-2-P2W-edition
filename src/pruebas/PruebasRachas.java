package pruebas;

import java.util.ArrayList;

import modelos.Player;
import modelos.Position;

public class PruebasRachas {
     
     private int killStreak;
     private ArrayList<String> streak;
     private Player player;

     public PruebasRachas(){
          this.killStreak = 0;
          this.streak = new ArrayList<>();
     }

     public int getKillStreak(){
          return killStreak;
     }

     public ArrayList<String> getStreak(){
          return streak;
     }

    public void unlockStreak(){
          if (killStreak == 3 && !streak.contains("UAV")){
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
               System.out.println(player.getName() + "Desplegando UAV...");
               opponent.getBoard().display();
               streak.remove("UAV");
          } else {
               System.out.println("No hay suficientes Puntos");
          }
    }

    public void useAirStrike(Player opponent, Position Position){
          if(streak.contains("AirStrike")){
               System.out.println(player.getName() + "Esta usando AirStrike");
               boolean hit = player.attack(opponent, Position);
               if(hit){
                    System.out.println("-1hp");
                    killStreak++;
               } else {
                    System.out.println("Miss!");
                    killStreak = 0;
               }
               streak.remove("AirStrike");
          } else {
               System.out.println("AirStrike no disponible");
          }
    }

    public void useNuke(Player opponent){
     if(streak.contains("Nuke")){
          System.out.println(player.getName() + "Ha usado nuke");
          System.out.println("3... 2... 1...");
          for (int i = 0; i<opponent.getBoard().)
     }
    }
}
