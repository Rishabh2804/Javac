package all_possible_ways;

public class Solution {

    public static int allWays(int i, int max, double x, int n) {
        if (x == 0)
            return 1;

        if (i > max)
            return 0;

        if (i == max) {
            if (Math.pow(i, n) == x)
                return 1;
            else
                return 0;
        }

        int way1 = allWays(i + 1, max, x, n);
        int way2 = allWays(i + 1, max, x - Math.pow(i, n), n);

        return way1 + way2;
    }

    public static int allWays(int x, int n) {

        int max;
        for (max = 0; Math.pow(max + 1, n) <= x; max++)
            ;

        return allWays(1, max, x, n);

    }

}
