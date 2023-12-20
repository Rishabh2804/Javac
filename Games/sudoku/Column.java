package sudoku;

import java.util.ArrayList;

public class Column {
    Cell[] cells;
    ArrayList<Integer> valuesPresent;

    public Column() {
        cells = new Cell[9];
        valuesPresent = new ArrayList<>();
    }

}
