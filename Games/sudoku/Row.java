package sudoku;

import java.util.ArrayList;

public class Row {
    Cell[] cells;
    ArrayList<Integer> valuesPresent;

    public Row() {
        cells = new Cell[9];
        valuesPresent = new ArrayList<>();
    }

}
