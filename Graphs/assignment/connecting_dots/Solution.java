package assignment.connecting_dots;

public class Solution {

    int solve(String[] board, int n, int m) {

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (visited[i][j]) {
                    continue;
                }

                if (solve2(board, board[i].charAt(j), i, j, 1, -1, -1, visited))
                    return 1;

            }
        }

        return 0;
    }

    int[] xDir = { 0, 0, 1,-1};
    int[] yDir = { 1,-1, 0, 0};

    boolean solve2(String[] board, char c, int i, int j, int k, int fromX, int fromY, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length();

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (board[i].charAt(j) != c) {
            return false;
        }

        if (visited[i][j]) {
            return true;
        } else {
            visited[i][j] = true;
        }

        for(int a = 0; a < 4; ++a){
            int nextX = i + xDir[a];
            int nextY = j + yDir[a];
            
            if(nextX == fromX && nextY == fromY)
                continue;
            
            if (solve2(board, c, nextX, nextY, k + 1, i, j, visited)) {
                return true;
            }
            
        }

        return false;
    }

}