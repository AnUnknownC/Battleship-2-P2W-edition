package modelos;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ship {
    private Position startPosition;
    private int length;
    private boolean isHorizontal;
    private Map<Position, Boolean> hits;

    public Ship(Position startPosition, int length, boolean isHorizontal) {
        this.startPosition = startPosition;
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.hits = new LinkedHashMap<>();
        fillHit();
    }

    private void fillHit(){
        if (isHorizontal){
            for (int i = 0; i < length; i++) {
                hits.put(new Position(startPosition.getRow() + i,startPosition.getColumn() ), false);
            }
        }else {
            for (int i = 0; i < length; i++) {
                hits.put(new Position(startPosition.getRow(),startPosition.getColumn() + i), false);
            }
        }
    }

    public Position getStartPosition(){return startPosition;}

    public int getShipLength() {return length;}

    public Map<Position, Boolean> getHits() {return hits;}

    //Confirma si el barco esta hundido
    public boolean isSunken() {
        for (boolean hit: hits.values()){
            if (!hit) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "length=" + length +
                ", isHorizontal=" + isHorizontal +
                ", hits=" + hits +
                '}';
    }
}
