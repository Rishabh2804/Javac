package tic_tac_toe;

import java.util.*;

public class Main {
    private static Player p1, p2;
    private static Board board;

    public static Scanner s = new Scanner(System.in);

    public static Player takeInput(int n, char symbol) {
        Player p = new Player();

        boolean isValid;

        isValid = false;

        do {
            try {
                System.out.print("Enter PLayer " + n + "'s Name : ");
                p.setName(s.next());
                isValid = true;

            } catch (InvalidName e) {
                System.out.print("Please enter a valid name!!\n");
            }
        } while (!isValid);

        isValid = false;

        do {
            try {
                System.out.print("Enter symbol for PLayer " + n + " (other than !) : ");
                p.setSymbol(s.next().charAt(0));

                if (p.getSymbol() == symbol)
                    throw new InvalidSymbol();

                isValid = true;

            } catch (InvalidSymbol e) {
                System.out.println("Please enter a valid Symbol!!\n");
            }
        } while (!isValid);

        return p;
    }

    public static void play() {

        p1 = takeInput(1, '\0');
        System.out.println();
        p2 = takeInput(2, p1.getSymbol());

        board = new Board(p1.getSymbol(), p2.getSymbol());

        System.out.println("\nLet's play!!");
        System.out.println("Enter ! to quit anytime");

        int turn = 1;
        int status = Board.INCOMPLETE;
        while (status == Board.INCOMPLETE) {
            try {
                if (turn == 1) {
                    System.out.println("\nPlayer 1 - " + p1.getName() + "'s turn\n");

                    System.out.print("Enter x : ");
                    int x = s.nextInt();

                    System.out.print("Enter y : ");
                    int y = s.nextInt();

                    status = board.move(x, y, p1, 1);

                } else {
                    System.out.println("\nPlayer 2 - " + p2.getName() + "'s turn\n");

                    System.out.print("Enter x : ");
                    int x = s.nextInt();

                    System.out.print("Enter y : ");
                    int y = s.nextInt();

                    status = board.move(x, y, p2, 2);
                }

                turn = 3 - turn;

            } catch (InvalidMove e) {
                System.out.println("Invalid Move!!");
            } finally{
                System.out.println();
                board.displayBoard();
            }

        }

        switch (status) {
            case 0:
                System.out.println(
                        "It's a DRAW!! Both of you played so well that we couldn't figure out a definite winner!! ");
                break;

            case 1:
                System.out.println("Congratulations " + p1.getName() + " for WINNING this game. Great compettion from "
                        + p2.getName() + " though. Cheers!!");
                break;

            case 2:
                System.out.println("Congratulations " + p2.getName() + " for WINNING this game. Great compettion from "
                        + p1.getName() + " though. Cheers!!");
                break;
        }

    }

    public static void main(String[] args) {
        play();
    }

}
