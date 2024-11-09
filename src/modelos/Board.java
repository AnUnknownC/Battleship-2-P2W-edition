package modelos;

public class Board {
    private int size;
    private char[][] grid;

    public Board() {
        this.size = 10; //El tamaño original seran 20, pero prueben con 10 para que vean como funciona
        grid = new char[size][size];
        initializeGrid();
    }

    public void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-'; // '-' -> es agua
            }
        }
    }

    /* Verificara si se puede colocar un barco */
    public boolean canPlaceShip(Ship ship) {
        int rowLimit = ship.getShipLength() + ship.getStartPosition().getRow();
        int columnLimit = ship.getShipLength() + ship.getStartPosition().getColumn();
        if (columnLimit <= size && rowLimit <= size){
            for(Position position: ship.getHits().keySet()){
                char actualPosition = grid[position.getRow()][position.getColumn()];
                if (actualPosition == 'H' && !ship.getHits().get(position)){
                    System.out.println("There is already a ship in one of the cells, try again");
                    return false;
                } else if (actualPosition != 'H' && !ship.getHits().get(position)){
                    grid[position.getRow()][position.getColumn()] = 'H';
                } else if (actualPosition != 'H' && ship.getHits().get(position)) {
                    grid[position.getRow()][position.getColumn()] = 'X';
                }
            }
            System.out.println("Ship successfully placed");
            return true;
        }
        System.out.println("The ship is out of the limits, use another start position");
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void showDamage(Position position, Boolean confirmer) {
        if (confirmer){
            grid[position.getRow()][position.getColumn()] = 'X';
        }else {
            grid[position.getRow()][position.getColumn()] = '0';
        }
    }

    public boolean validateCoordinate(Position position){
        return position.getRow() <= size && position.getColumn() <= size;
    }

    public boolean moveShip(Ship shipToChange, Position newPosition, boolean newIsHorizontal) {
        Ship ship = new Ship(newPosition, shipToChange.getShipLength(), !newIsHorizontal);
        ship.setHits(ship.changeValues(shipToChange));
        for (Position position: shipToChange.getHits().keySet()){
            grid[position.getRow()][position.getColumn()] = '-';
        }
        if (canPlaceShip(ship)){
            return true;
        }
        canPlaceShip(shipToChange);
        return false;
    }
}
