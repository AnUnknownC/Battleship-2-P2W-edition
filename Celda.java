public class Celda {
    
    Barco barco;

    public Celda(){
        this.barco = null; // La celda inicialmente debe estar vacia
    }

    public boolean celdaVacia(){ 
        return this.barco == null;
    }

    public void colocarBarco(Barco barco){
        this.barco = barco; // ocupar el barco en la celda
    }

    public Barco getBarco(){
        return barco;
    }
}
