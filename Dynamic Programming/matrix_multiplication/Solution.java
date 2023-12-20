package matrix_multiplication;

import java.util.Arrays;

public class Solution {

    public static int[][] mult = new int[100][100];

    public static int mcm(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (mult[i][j] != -1) {
            return mult[i][j];
        }
        mult[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            mult[i][j] = Math.min(mult[i][j],
                    mcm(p, i, k) + mcm(p, k + 1, j) + p[i - 1] * p[k] * p[j]);
        }
        return mult[i][j];
    }

    public static int mcm(int[] p) {
        int n=p.length;
        int i = 1, j = n - 1;
        
        for(int[] row : mult){
            Arrays.fill(row, -1);
        }
        return mcm(p, i, j);
    }

}
