package max_sq_matrix_all0;

public class Solution {

    public static int findMaxSquareWithAllZeros(int[][] input) {
        if (input.length == 0)
            return 0;

        int m = input.length;
        int n = input[0].length;
        int max = 0;

        int[][] size = new int[m][n];

        for (int i = 0; i < m; ++i) {
            size[i][0] = 1 - input[i][0]; // 1 for 0 and 0 for 1
        }

        for (int i = 0; i < n; ++i) {
            size[0][i] = 1 - input[0][i];
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (input[i][j] == 1) {
                    size[i][j] = 0;
                } else {
                    size[i][j] = 1 + Math.min(size[i - 1][j - 1], Math.min(size[i][j - 1], size[i - 1][j]));
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (size[i][j] > max) {
                    max = size[i][j];
                }
            }
        }

        return max;

    }

}
