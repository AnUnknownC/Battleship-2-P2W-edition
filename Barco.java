import java.util.ArrayList;

public class Barco {

    private int tamanioBarco;
    private boolean orientacion; // true -> Horizontal false -> Vertical
    private ArrayList<Coordenada> posicion; // Un array con las cordenadas del barco
    private int impacto;


    public Barco(int tamanioBarco, boolean orientacion, ArrayList<Coordenada> posicion, int impacto) {
        this.tamanioBarco = tamanioBarco;
        this.orientacion = orientacion;
        this.posicion = new ArrayList<>();
        this.impacto = 0; // No hay impactos al inicio de partida
    }

    public int getTamanioBarco() {
        return tamanioBarco;
    }

    public boolean isOrientacion() {
        return orientacion;
    }

    public ArrayList<Coordenada> getPosicion() {
        return posicion;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setOrientacion(boolean orientacion) {
        this.orientacion = orientacion;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public void setPosicion(ArrayList<Coordenada> posicion) {
        this.posicion = posicion;
    }


    /*
     * Metodos
     */

    //contador de impactos

   public void recibirImpacto(){
        impacto++;
   }

   // Un barco es hundido cuando el numero de impactos es >= al tamaño del mismo
   public boolean esHundido(){
        return impacto >= tamanioBarco; 
   }

   // Agregar una posicion al arrayList de coordenada
   public void agregarPosicion(Coordenada coordenada){
        posicion.add(coordenada);
   }






}


