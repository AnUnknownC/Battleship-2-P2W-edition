
import java.util.ArrayList;

public class SistemaRachas {
    
    private ArrayList<RachaBaja> rachas;
    private int puntosAculmulados;

    public SistemaRachas(){
        rachas = new ArrayList<>();
        puntosAculmulados = 0;


        rachas.add(new RachaBaja("UAV", 1500, "Revela las posiciones cercanas de un barco"));
        rachas.add(new RachaBaja("MisilRoto", 2000, "MisilDoble"));
    }

    public void agregarPuntos(int puntos){
        puntosAculmulados += puntos;
    }

    public String CanjearRachas(){
        return null;
    }

    public void verificarRacha(){
        
    }

   

}
