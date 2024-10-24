

public class RachaBaja {

    private String nombre;
    private int puntosRequeridos;
    private String efecto;
    private Jugador jugador;

    public RachaBaja(String nombre, int puntosRequeridos, String efecto){
        this.nombre = nombre;
        this.puntosRequeridos = puntosRequeridos;
        this.efecto = efecto;
    }

    public boolean desbloqueada(){
        return jugador.getPuntaje() >= puntosRequeridos;
    }

    public void activarEfecto(){
        System.out.println("Efecto" + efecto);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosRequeridos() {
        return puntosRequeridos;
    }

}
