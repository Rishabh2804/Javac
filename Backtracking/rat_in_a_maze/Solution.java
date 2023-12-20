package rat_in_a_maze;

public class Solution {

	static int[] xDir = { -1, 0, 0, 1 };
	static int[] yDir = { 0, -1, 1, 0 };

	public static boolean ratInAMaze(int maze[][], int i, int j, boolean[][] visited) {
		int n = maze.length;
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return false;
		}

		if (i == n - 1 && j == n - 1) {
			return true;
		}

		if (maze[i][j] == 0 || visited[i][j]) {
			return false;
		}

		visited[i][j] = true;

		for (int dir = 0; dir < 4; ++dir) {

			if (ratInAMaze(maze, i + xDir[dir], j + yDir[dir], visited)) {
				return true;
			}
		}

		return false;
	}

	public static boolean ratInAMaze(int maze[][]) {
		int n = maze.length;

		boolean[][] visited = new boolean[n][n];
		return ratInAMaze(maze, 0, 0, visited);
	}

	public static void ratInAMaze(int maze[][], int n, int i, int j, int[][] path) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return;
		}

		if (i == n - 1 && j == n - 1) {
			path[i][j] = 1;
			for (int r = 0; r < n; ++r) {
				for (int c = 0; c < n; ++c) {
					System.out.print(path[r][c] + " ");
				}
			}
			System.out.println();

			path[i][j] = 0;
			return;
		}

		if (maze[i][j] == 0 || path[i][j] == 1) {
			return;
		}

		path[i][j] = 1;

		for (int dir = 0; dir < 4; ++dir) {
			ratInAMaze(maze, n, i + xDir[dir], j + yDir[dir], path);
		}

		path[i][j] = 0;

	}

	public static void ratInAMaze(int maze[][], int n) {

		int[][] path = new int[n][n];
		ratInAMaze(maze, n, 0, 0, path);
	}
}
