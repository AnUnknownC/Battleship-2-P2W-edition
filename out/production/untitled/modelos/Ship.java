package modelos;

import java.util.*;

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

    public void setHits(Map<Position, Boolean> hits) {this.hits = hits;}

    //Confirma si el barco esta hundido
    public boolean isSunken() {
        for (boolean hit: hits.values()){
            if (!hit) return false;
        }
        return true;
    }

    public Map<Position, Boolean> changeValues(Ship shipToChange) {
        Iterator<Position> keys = hits.keySet().iterator();
        Iterator<Boolean> values = shipToChange.hits.values().iterator();
        while (keys.hasNext() && values.hasNext()){
            hits.put(keys.next(), values.next());
        }
        return hits;
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
