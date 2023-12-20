package tic_tac_toe;

class InvalidMove extends Exception {

}

public class Board {

    private char board[][];
    private int boardSize = 3;
    char P1symbol, P2symbol;
    int count;

    public final static int DRAW = 0;
    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int INCOMPLETE = 3;

    public Board(char P1symbol, char P2symbol) {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                board[i][j] = '_';
            }
        }

        this.P1symbol = P1symbol;
        this.P2symbol = P2symbol;
        count = boardSize * boardSize;
    }

    public Board(char P1symbol, char P2symbol, int boardSize) {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                board[i][j] = '_';
            }
        }

        this.P1symbol = P1symbol;
        this.P2symbol = P2symbol;
    }

    public void displayBoard() {

        for (char[] row : board) {

            for (char c : row) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
    }

    public boolean isWin(char symbol) {

        boolean win = true;

        // horizontal check
        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                // win = win && i == symbol;
                if (board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return win;
            }

        }

        win = true;
        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                // win = win && i == symbol;
                if (board[j][i] != symbol) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return win;
            }

        }

        win = true;
        for (int i = 0; i < boardSize; ++i) {
            // left diagonal check
            // win = win && board[i][i] == symbol;
            if (board[i][i] != symbol)
                win = false;
        }

        if (win) {
            return win;
        }

        win = true;
        for (int i = 0; i < boardSize; ++i) {
            // right diagonal check
            // win = win && board[i][boardSize - i - 1] == symbol;
            if (board[i][boardSize - i - 1] != symbol)
                win = false;
        }

        return win;
    }

    public int move(int x, int y, Player p, int P_No) throws InvalidMove {
        if (board[x][y] != '_') {
            throw new InvalidMove();
        }

        board[x][y] = p.getSymbol();
        count--;

        if (isWin(p.getSymbol())) {
            if (P_No == 1) {
                return PLAYER_1_WINS;
            } else {
                return PLAYER_2_WINS;
            }
        }

        if (count == 0) {
            return DRAW;
        }

        return INCOMPLETE;
    }

}
