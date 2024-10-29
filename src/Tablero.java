public class Tablero {
    
    private int[][] tablero;
    private int tamanio;
    private Barco barco;

    public Tablero( int tamanio) {
        this.tablero = new int[tamanio][tamanio];
        this.tamanio = tamanio;
    }
    
    public void colocarBarco(Barco barco, Coordenada posicionInicial, boolean orientacion){

        // Verificar si la celda esta vacia, cambiar la orientacion y la posicion       

    }
    
    public boolean verificarImpacto(Coordenada posicion){
        // Verificar si un barco ha sido golpeado
        return false;
    }

    public void mostrarTablero(){

    }
}
