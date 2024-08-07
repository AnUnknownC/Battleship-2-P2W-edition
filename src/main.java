package Steam_N1;
import javax.swing.*;
public class main {

    public static void main(String[] args) {
        
        Barco Player_1 = new Barco();

        Player_1.config_team(JOptionPane.showInputDialog("Ingrese su equipo Azul/Rojo: "));

        System.out.println(Player_1.tell_team());



    }
    
}
