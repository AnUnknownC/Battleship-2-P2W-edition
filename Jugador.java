import java.util.ArrayList;


public class Jugador {

    private ArrayList<Barco> barco;
    private String nombre;
    private Tablero tablero;
    private int puntaje;

    public Jugador(ArrayList<Barco> barco, String nombre, Tablero tablero) {
        this.barco = new ArrayList<>();
        this.nombre = nombre;
        this.tablero = tablero;
    }

    public ArrayList<Barco> getBarco() {
        return barco;
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public int getPuntaje() {
        return puntaje;
    }

    /*
     * Metodos
     */

    public void colocarBarco(ArrayList<Barco> barco, Coordenada posicionInicial, boolean orientacion){

        // Verificar si la casilla esta vacia, verificar la nueva orientacion y finalmente la nueva orientacion        

    }

    public String atacar(Jugador jugador2, Coordenada posicion) {
        // Recorrer el tablero con las cordenadas y verificar si hay un barco enemigo ahi
        return "Se ha atacado a la casilla";
    }


    public String derrota(){
        // Verificar si aun existen Barcos y si es el caso retornar false, si no true  
        return "";
    }

    public void puntajeAumento(){
        // Hacer la condicion y aumentar el puntaje
    }
}
