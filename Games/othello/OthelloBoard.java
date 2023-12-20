package othello;

public class OthelloBoard {

	private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public OthelloBoard() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private int[] xDir = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private int[] yDir = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public boolean move(int symbol, int x, int y) {
		if (board[x][y] != 0)
			return false;

		boolean change = false;

		for (int i = 0; i < xDir.length; ++i) {
			int tempx = x + xDir[i];
			int tempy = y + yDir[i];
		
			boolean convert = false;

			while (true) {

				if (xDir[i] < 0 && tempx < 0) {
					break;
				} else if (tempx >= 8) {
					break;
				}

				if (yDir[i] < 0 && tempy < 0) {
					break;
				} else if (tempy >= 8) {
					break;
				}

				if (board[tempx][tempy] == 0) {
					break;
				}

				if (board[tempx][tempy] == symbol) {
					if (tempx != x + xDir[i] || tempy != y + yDir[i]) {
						change = true;
						convert = true;
					}

					break;
				}

				tempx += xDir[i];
				tempy += yDir[i];
			}

			if (!convert) {
				continue;
			}

			int a = x, b = y;

			while (true) {

				if (xDir[i] < 0 && a < tempx) {
					break;
				} else if (xDir[i] >= 0 && a > tempx) {
					break;
				}

				if (yDir[i] < 0 && b < tempy) {
					break;
				} else if (yDir[i] >= 0 && b > tempy) {
					break;
				}

				board[a][b] = symbol;

				a += xDir[i];
				b += yDir[i];

			}

		}

		return change;
	}
}
