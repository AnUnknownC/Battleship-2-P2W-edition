package modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class Streak {
    private int killStreak;
    private ArrayList<String> availableStreaks;

    public Streak(){
        this.killStreak = 0;
        this.availableStreaks = new ArrayList<>();
    }

    public int getKillStreak() {return killStreak;}

    public void updateKillStreak(boolean confirmer){
        if (confirmer){
            killStreak++;
            unlockStreak();
        }else {
            killStreak = 0;
        }
    }

    public ArrayList<String> getAvailableStreaks(){
        return availableStreaks;
    }

    //En este caso no necesitamos pedir como parametro la killStreak, ya que la tenemos en esta clase
    public void unlockStreak(){
        if (killStreak == 4 && !availableStreaks.contains("UAV")){
            availableStreaks.add("UAV");
            System.out.println("UAV on line for its use!");
        }
        else if (killStreak == 5 && !availableStreaks.contains("AIRSTRIKE")){
            availableStreaks.add("AIRSTRIKE");
            System.out.println("AirStrike available!");
        }
        else if (killStreak == 8 && !availableStreaks.contains("NUKE")){
            availableStreaks.add("NUKE");
            System.out.println("¡Nuke alert, it's time to blow them up!");
        }
    }

    public void useUAV(Player opponent){
        if(availableStreaks.contains("UAV")){
            System.out.println("Deploying UAV...");
            opponent.getBoard().display();
            availableStreaks.remove("UAV");
        } else {
            System.out.println("UAV not available");
        }
    }

    public void useAirStrike(Player opponent){
        if(availableStreaks.contains("AIRSTRIKE")){
            System.out.println("Sending the AirStrike");
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Type the position to attack (Row - Column)");
                Position possibleHit = new Position(scanner.nextInt(), scanner.nextInt());
                if (opponent.getBoard().validateCoordinate(possibleHit)){
                    opponent.attack(opponent, possibleHit);
                    break;
                } else {
                    System.out.println("Shot out of bounds, let's focus in the enemy field commander");
                }
            }
            availableStreaks.remove("AIRSTRIKE");
        } else {
            System.out.println("AirStrike not available");
        }
    }

    public void useNuke(Player opponent){
        if(availableStreaks.contains("NUKE")){
            System.out.println("Using nuke");
            System.out.println("3... 2... 1...");
            for (int i = 0; i<opponent.getBoard().getSize(); i++){
                for (int j = 0; j< opponent.getBoard().getSize(); j++){
                    opponent.attackNuke(opponent, (new Position(i,j)));
                }
            }
        } else {
            System.out.println("Nuke not available");
        }
    }
}
