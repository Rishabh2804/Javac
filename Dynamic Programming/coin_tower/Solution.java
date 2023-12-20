package coin_tower;

public class Solution {

    public static String findWinner(int n, int x, int y) {

        boolean[] win = new boolean[n + 1];
        win[0] = false; // can't pick 0 coins in any way
        win[1] = true; // any player can pick atleast 1 coin

        for (int i = 2; i <= n; ++i) {
            win[i] = false;
        }

        for (int i = 2; i <= n; ++i) {
            boolean a1 = !win[i - 1];
            boolean a2 = i - x >= 0 && !win[i - x];
            boolean a3 = i - y >= 0 && !win[i-y];

            if (a1 || a2 || a3)
                win[i] = true;
            else
                win[i] = false;
        }

        if (win[n])
            return "Beerus";
        else
            return "Whis";
    }

}
