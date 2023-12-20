package assignment.largest_piece;

public class Solution {

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int k;

    public static int dfs(String[] edge, int n) {

        int ans = 0;
        char[][] cake = new char[n][n];

        for (int i = 0; i < n; ++i) {
            cake[i] = edge[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (cake[i][j] == '1') {
                    k = 0;
                    solve(cake, n, i, j);
                    ans = Math.max(ans, k);
                }
            }
        }

        return ans;
    }

    public static void solve(char[][] cake, int n, int i, int j) {
        k++;
        cake[i][j]='0';

        if (i + 1 < n && cake[i + 1][j] == '1')
            solve(cake, n, i + 1, j);
        if (i - 1 >= 0 && cake[i - 1][j] == '1')
            solve(cake, n, i - 1, j);
        if (j + 1 < n && cake[i][j + 1] == '1')
            solve(cake, n, i, j + 1);
        if (j - 1 >= 0 && cake[i][j - 1] == '1')
            solve(cake, n, i, j - 1);

    }

}