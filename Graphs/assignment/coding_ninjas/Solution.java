package assignment.coding_ninjas;

class Pair {
    int i;
    int j;
}

public class Solution {

    String ninja = "CODINGNINJA";

    boolean solve2(String[] graph, int i, int j, int k, boolean[][] visited) {
        if (k >= 11) {
            return true;
        }

        int n = graph.length;
        int m = graph[0].length();

        visited[i][j] = true;

        for (int a = i - 1; a <= i + 1; ++a) {
            if (a < 0 || a >= n) {
                continue;
            }

            for (int b = j - 1; b <= j + 1; ++b) {
                if (b < 0 || b >= m || visited[a][b]) {
                    continue;
                }

                if (a == i && b == j) {
                    continue;
                }

                if (graph[a].charAt(b) != ninja.charAt(k)) {
                    continue;
                }

                if (solve2(graph, a, b, k + 1, visited)) {
                    return true;
                }

            }
        }

        visited[i][j] = false;
        return false;
    }

    int solve(String[] graph, int n, int m) {

        boolean[][] visited = new boolean[n][m];

        int i = 0, j = 0;

        for (i = 0; i < n; ++i) {
            for (j = 0; j < m; ++j) {
                
                if (graph[i].charAt(j) == 'C') {
                    visited[i][j] = true;
                    if (solve2(graph, i, j, 1, visited)) {
                        return 1;
                    }
                }
            }
        }

        return 0;

    }

}