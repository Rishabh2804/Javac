package sudoku;

import java.util.ArrayList;

public class Box {
    Cell[] cells;
    ArrayList<Integer> valuesPresent;

    public Box() {
        cells = new Cell[9];
        valuesPresent = new ArrayList<>();
    }

}
