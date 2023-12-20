package sudoku;

public class Cell {
    int value;
    boolean isOccupied;
    boolean[] values;

    public Cell() {
        value = 0;
        isOccupied = false;
        values = new boolean[9];
    }

}
