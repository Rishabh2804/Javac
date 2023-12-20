package n_queens;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Solution.placeNQueens(n);
        s.close();
    }
}
