package Steam_N1;

public class Barco {
    
    private int hp;

    private int def;

    private int dmg;

    private Boolean team;

    public Barco() {

        hp = 5;

        def = 2;

        dmg = 2;

    }

   public void config_team (String team) {

    if (team.equalsIgnoreCase("Azul")) {

        this.team = true;

    }
    else{

        this.team = false;

    }
   }


   public String tell_team () {

    if (team == true) {

        return "Has ingresado al equipo Azul!";

    }

    else {

        return "Te ha tocado el equipo Rojo!";
    }


   }
}
